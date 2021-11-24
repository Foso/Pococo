package de.jensklingenberg.pococo.converter.retrofit.model

data class MyAnnotation(val key: String, val value: String)

data class MyFunction(
    val name: String,
    val annotations: List<MyAnnotation>,
    val comment: String?,
    val myParam: List<MyParam>,
    val description : String?=null,
    val body : String?=null
)

data class MyParam(val name: String, val type: String, val myAnnotation: MyAnnotation?, val default: String? = null,val description:String?=null)