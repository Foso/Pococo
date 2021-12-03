package de.jensklingenberg.pococo.converter.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.jensklingenberg.pococo.converter.retrofit.model.MyAnnotation
import de.jensklingenberg.pococo.converter.retrofit.model.MyFunction
import de.jensklingenberg.pococo.converter.retrofit.model.MyParam
import de.jensklingenberg.pococo.converter.retrofit.model.RetrofitAnnotation
import de.jensklingenberg.pococo.core.model.CollectionData
import de.jensklingenberg.pococo.core.model.ItemItem
import de.jensklingenberg.pococo.core.model.Request
import de.jensklingenberg.pococo.core.model.VariableItem
import java.io.File
import java.util.*


fun main() {
    readFile("/home/jens/Code/2021/jk/Pococo/retrofit/src/main/kotlin/de/jensklingenberg/pococo/converter/retrofit/collection/bitrise.json")
}

fun readFile(filePath: String) {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val str =
        File(filePath).readText()

    val jsonAdapter = moshi.adapter(CollectionData::class.java)
    val collectionData = jsonAdapter.fromJson(str)

    collectionData?.let {
        generateCode(it, filePath.substringBeforeLast("/"))
    }
}


fun generateCode(collectionData: CollectionData, folderPath: String) {

    val fileName = collectionData.info?.name?.replace(" ", "")

    val myFunctions = mutableListOf<MyFunction>()

    collectionData.item.forEach { itemItem ->
        parseRequests(myFunctions, itemItem, collectionData)
    }

    val functionTexts = myFunctions.map { myFunc ->
        val paramsText = myFunc.myParam.joinToString { myParam ->
            val myAnnotation = myParam.myAnnotation
            val queryValue = if (myAnnotation?.value?.isNotEmpty() == true) {
                "(\"" + myAnnotation.value + "\")"
            } else {
                ""
            }
            "${myAnnotation?.key}$queryValue ${myParam.name} : ${myParam.type}"
        }
        val annosText = myFunc.annotations.joinToString(separator = "\n") { it.key + "(${it.value})" }

        val func = "fun ${myFunc.name}($paramsText) : Any"
        return@map """
     
${myFunc.comment}
$annosText
$func

          """.trimMargin()
    }

    File(folderPath+ "/${fileName}Service.kt").writeText(
        "import retrofit2.http.* \n " +
                "interface ${fileName}Service{\n" +
                functionTexts.joinToString(separator = "\n") { it } + "\n}"
    )

    val generateBodies = false

    if(generateBodies){
        val bodyClassText = myFunctions.filter { it.body != null }
            .joinToString(separator = "\n") { "val ${it.name}Body = \"\"\"${it.body}\"\"\"" }
        bodyClassText.let {
            File(folderPath + "/${fileName}Bodies.kt").writeText(
                bodyClassText
            )
        }
    }

}




fun parseRequests(myFunctions: MutableList<MyFunction>, item: ItemItem, collectionData: CollectionData) {
    if (item.request == null) {
        item.item?.filterNotNull()?.forEach {
            parseRequests(myFunctions, it, collectionData)
        }
    } else {
        getMyFunction(collectionData.variable, item.request!!, item.name).let {
            myFunctions.add(it)
        }
    }
}

fun generateFunctionCommentText(params: MutableList<MyParam>, description: String?): String {
    var comment = ""

    if (!description.isNullOrEmpty()) {
        comment = "* $description\n"
    }

    params.forEach {
        comment = comment + "* @param " + cleanParamName(it.name ?: "") + " " + (it.description ?: "") + "\n"
    }


    if (comment.isNotEmpty()) {
        comment = "/**\n$comment**/"
    }
    return comment
}

fun getMyFunction(
    variables: List<VariableItem>,
    request: Request,
    itemName: String?
): MyFunction {

    val myAnnotation = mutableListOf<MyAnnotation>()
    val params = mutableListOf<MyParam>()
    /**
     * Headers
     */
    generateHeaders(myAnnotation, request, variables)

    /**
     * MEthod Annotation
     */
    var urlValue = request.url?.raw ?: ""

    //Replace all postman variable with corresponding value
    variables.forEach {
        urlValue = urlValue.replace("{{${it.key}}}", it.value ?: "")
    }

    //Postman Path Variable in Url will be replaced from ":id" to "{id}" and will be added to the parameter list
    urlValue.substringBefore("?").split("/").filter { it.startsWith(":") }.forEach {
        val param = cleanParamName(name = it.substring(1))
        params.add(
            MyParam(
                param,
                type = "String",
                description = "",
                myAnnotation = MyAnnotation("@" + RetrofitAnnotation.PATH.annotationName, param ?: "")
            )
        )
        urlValue = urlValue.replace(it, "{${param}}")

    }

    //Get the query url part after the ?
    val queryStringList = urlValue.substringAfter("?", "").split("&").filter { it.isNotEmpty() }.toMutableList()


    request.url?.query?.forEach { queryItem ->
        queryStringList.removeIf { it.startsWith(queryItem.key ?: "") }
    }

    urlValue = urlValue.substringBefore("?")
    if (queryStringList.isNotEmpty()) {
        urlValue = urlValue + "?" + queryStringList.joinToString(separator = "&") { it }
    }

    val httpMethod = MyAnnotation(("@" + request.method), "\"$urlValue\"")
    myAnnotation.add(httpMethod)

    request.url?.query?.map {
        MyParam(
            name = cleanParamName(it.key ?: ""),
            type = "String",
            MyAnnotation("@" + RetrofitAnnotation.QUERY.annotationName, it.key ?: ""),
            description = it.description
        )
    }?.let {
        params.addAll(it)
    }
    val formData = request.body?.formdata

    request.body?.let {
        when (it.raw) {
            "raw" -> {
                params.add(
                    MyParam(
                        name = "body", "String",
                        myAnnotation = MyAnnotation("@Body", "")
                    )
                )
            }
            "formdata", "file" -> {
                //When Body is formData, Retrofit add the Multipart Annotation and the Part Annotation for the Parameter

                myAnnotation.add(MyAnnotation("@Multipart", ""))
                params.add(
                    MyParam(
                        name = "${formData?.firstOrNull()?.key}", "RequestBody",
                        myAnnotation = MyAnnotation("@Part", "${formData?.firstOrNull()?.key}")
                    )
                )
            }
            "urlencoded" -> {

            }

            "graphql" -> {

            }
            else -> {

            }
        }
    }

    val functionName = getFunctionName(itemName)
    val functionComment = generateFunctionCommentText(params, request.description)

    val myBody = if (request.body?.mode == "raw") {
        request.body?.raw
    } else {
        null
    }

    return MyFunction(
        name = functionName,
        comment = functionComment,
        annotations = myAnnotation,
        myParam = params,
        body = myBody
    )
}

fun getFunctionName(itemName: String?): String {
    val functionName = itemName?.split(" ")?.mapIndexed { index, s ->
        if (index == 0) {
            s.lowercase(Locale.getDefault())
        } else {
            s.lowercase(Locale.getDefault()).titleCase()
        }
    }?.joinToString(separator = "") { it } ?: ""
    return cleanFunName(functionName)
}

fun generateHeaders(
    myAnnotation: MutableList<MyAnnotation>,
    request: Request,
    collectionVariables: List<VariableItem>
) {
    val headersMap = request.header?.filterNotNull()?.filter { !it.key.isNullOrEmpty() }?.map {
        val oldValue = it.value ?: ""
        val headerValue = if (oldValue.startsWith("{{")) {
            collectionVariables.find { it.key == (oldValue.replace("{{", "").replace("}}", "")) }?.value
                ?: oldValue
        } else {
            oldValue
        }
        MyAnnotation(key = "@Header", value = "\"${it.key}: $headerValue \"")

    }?.toMutableList()

    when (request.auth?.type) {
        null -> {

        }
        "apikey" -> {
            request.auth?.apikey?.let {
                val key = it.find { it.key == "key" }?.value
                val value = it.find { it.key == "value" }?.value


                val anno = MyAnnotation(
                    "@Header", "\"$key: $value)\""
                )
                headersMap?.add(anno)
            }
        }


        "awsv4" -> {

        }
        "basic" -> {
//The Auth will be convertered to Base64 and set as Authorization Header
            request.auth?.basic?.let {
                val userName = it.find { it?.key == "username" }?.value
                val password = it.find { it?.key == "password" }?.value
                val anno = MyAnnotation(
                    "@Header", "\"Authorization: Basic " + Base64.getEncoder()
                        .encodeToString("$userName:$password".toByteArray()) + "\""
                )
                headersMap?.add(anno)
            }
        }
        "bearer" -> {

        }
        "digest" -> {

        }
        "edgegrid" -> {

        }
        "hawk" -> {

        }
        "noauth" -> {

        }
        "oauth1" -> {

        }
        "oauth2" -> {

        }
        "ntlm" -> {

        }
    }


    headersMap?.let {
        myAnnotation.add(MyAnnotation("@Headers", it.joinToString(separator = ",\n") { it.value }))
    }
}

