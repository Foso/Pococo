package de.jensklingenberg.pococo.core.model

import com.squareup.moshi.Json

data class CollectionData(

    @Json(name = "item")
    val item: List<ItemItem> = emptyList(),

    @Json(name = "variable")
    val variable: List<VariableItem> = emptyList(),

    @Json(name = "event")
    val event: List<EventItem?>? = null,

    @Json(name = "info")
    val info: Info? = null,

    @Json(name = "auth")
    val auth: Auth? = null,
)

data class Script(

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "exec")
    val exec: List<String?>? = null
)

data class Info(

    @Json(name = "schema")
    val schema: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "_postman_id")
    val postmanId: String? = null
)

data class ProtocolProfileBehavior(

    @Json(name = "disableBodyPruning")
    val disableBodyPruning: Boolean? = null
)

data class ItemItem(

    @Json(name = "item")
    val item: List<ItemItem?>? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "auth")
    val auth: Auth? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "event")
    val event: List<EventItem?>? = null,

    @Json(name = "request")
    val request: Request? = null,

    @Json(name = "response")
    val response: List<ResponseItem?>? = null,

    @Json(name = "protocolProfileBehavior")
    val protocolProfileBehavior: ProtocolProfileBehavior? = null
)

data class OriginalRequest(

    @Json(name = "method")
    val method: String? = null,

    @Json(name = "header")
    val header: List<Any?>? = null,

    @Json(name = "url")
    val url: Url? = null,

    @Json(name = "body")
    val body: Body? = null
)

data class ResponseItem(

    @Json(name = "originalRequest")
    val originalRequest: OriginalRequest? = null,

    @Json(name = "_postman_previewlanguage")
    val postmanPreviewlanguage: String? = null,

    @Json(name = "code")
    val code: Int? = null,

    @Json(name = "cookie")
    val cookie: List<Any?>? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "header")
    val header: List<HeaderItem?>? = null,

    @Json(name = "body")
    val body: String? = null,

    @Json(name = "status")
    val status: String? = null
)

data class Body(

    @Json(name = "mode")
    val mode: String? = null,

    @Json(name = "raw")
    val raw: String? = null,

    @Json(name = "formdata")
    val formdata: List<FormdataItem>? = null,

    @Json(name = "graphql")
    val graphql: Graphql? = null
)


data class Graphql(

    @Json(name = "variables")
    val variables: String? = null,

    @Json(name = "query")
    val query: String? = null
)

data class FormdataItem(

    @Json(name = "src")
    val src: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "key")
    val key: String? = null
)

data class EventItem(

    @Json(name = "listen")
    val listen: String? = null,

    @Json(name = "script")
    val script: Script? = null
)


data class HeaderItem(

    @Json(name = "value")
    val value: String? = null,

    @Json(name = "key")
    val key: String? = null
)

data class DVKItem(

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "value")
    val value: String? = null,

    @Json(name = "key")
    val key: String? = null
)

typealias QueryItem = DVKItem
typealias VariableItem= DVKItem

data class Request(

    @Json(name = "method")
    val method: String? = null,
    @Json(name = "auth")
    val auth: Auth? = null,
    @Json(name = "header")
    val header: List<HeaderItem?>? = null,

    @Json(name = "url")
    val url: Url? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "body")
    val body: Body? = null,
)

data class BasicItem(

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "value")
    val value: String? = null,

    @Json(name = "key")
    val key: String? = null
)

data class Auth(

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "basic")
    val basic: List<BasicItem?>? = null,

    @Json(name="apikey")
    val apikey: List<BasicItem>? = null,

)

data class Url(

    @Json(name = "path")
    val path: List<String> = emptyList(),

    @Json(name = "host")
    val host: List<String> = emptyList(),

    @Json(name = "raw")
    val raw: String? = null,

    @Json(name = "protocol")
    val protocol: String? = null,

    @Json(name = "query")
    val query: List<QueryItem> = emptyList(),

    @Json(name = "variable")
    val variable: List<QueryItem> = emptyList()
)

