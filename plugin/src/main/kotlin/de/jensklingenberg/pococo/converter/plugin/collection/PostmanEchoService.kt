import retrofit2.http.* 
 interface PostmanEchoService{
     
/**
* Use this endpoint to get a list of all cookies that are stored with respect to this domain. Whatever key-value pairs that has been previously set by calling the "Set Cookies" endpoint, will be returned as response JSON.
**/
@Headers()
@GET("{{baseURL}}/cookies")
fun getCookies() : Any

     
/**
* The cookie setter endpoint accepts a list of cookies and their values as part of URL parameters of a `GET` request. These cookies are saved and can be subsequently retrieved or deleted. The response of this request returns a JSON with all cookies listed.

To set your own set of cookies, simply replace the URL parameters "foo1=bar1&foo2=bar2" with your own set of key-value pairs.
* @param foo1 
* @param foo2 
**/
@Headers()
@GET("{{baseURL}}/cookies/set")
fun setCookies(@Query("foo1") foo1 : String, @Query("foo2") foo2 : String) : Any

     
/**
* One or more cookies that has been set for this domain can be deleted by providing the cookie names as part of the URL parameter. The response of this request is a JSON containing the list of currently set cookies.
* @param foo1 
**/
@Headers()
@GET("{{baseURL}}/cookies/delete")
fun deleteCookies(@Query("foo1") foo1 : String) : Any

     
/**
* Performing a simple `GET` request to this endpoint returns status code `401 Unauthorized` with `WWW-Authenticate` header containing information to successfully authenticate subsequent requests.
The `WWW-Authenticate` header must be processed to extract `realm` and `nonce` values to hash subsequent requests.

When this request is executed within Postman, the script attached with this request does the hard work of extracting realm and nonce from the header and set it as [global variables](https://
**/
@Headers()
@GET("{{baseURL}}/digest-auth")
fun digestauthRequest() : Any

     
/**
* This endpoint simulates a **basic-auth** protected endpoint. 
The endpoint accepts a default username and password and returns a status code of `200 ok` only if the same is provided. 
Otherwise it will return a status code `401 unauthorized`.

> Username: `postman`
> 
> Password: `password`

To use this endpoint, send a request with the header `Authorization: Basic cG9zdG1hbjpwYXNzd29yZA==`. 
The cryptic latter half of the header value is a base64 encoded concatenation of the default username an
**/
@Headers()
@GET("{{baseURL}}/basic-auth")
fun basicAuth() : Any

     
/**
* OAuth1.0a is a specification that defines a protocol that can be used by one
service to access "protected" resources (endpoints) on another service. A
major part of OAuth1.0 is HTTP Request Signing. This endpoint allows you to 
check whether the request calculation works properly in the client. 

The endpoint supports the HTTP ``Authorization`` header. In case the signature
verification fails, the endpoint provides the four debug values,

* ``base_uri``
* ``normalized_param_string``
* ``base_str
**/
@Headers()
@GET("{{baseURL}}/oauth1")
fun oauth10VerifySignature() : Any

     
/**
* This endpoint is a Hawk Authentication protected endpoint. [Hawk authentication](https://github.com/hueniverse/hawk) is a widely used protocol for protecting API endpoints. One of Hawk's main goals is to enable HTTP authentication for services that do not use TLS (although it can be used in conjunction with TLS as well).

In order to use this endpoint, select the "Hawk Auth" helper inside Postman, and set the following values:

Hawk Auth ID: `dh37fgj492je`

Hawk Auth Key: `werxhqb98rpaxn39848xru
**/
@Headers()
@GET("{{baseURL}}/auth/hawk")
fun hawkAuth() : Any

     
/**
* A `GET` request to this endpoint returns the list of all request headers as part of the response JSON.
In Postman, sending your own set of headers through the [Headers tab](https://www.getpostman.com/docs/requests#headers?source=echo-collection-app-onboarding) will reveal the headers as part of the response.
**/
@Headers()
@GET("{{baseURL}}/headers")
fun requestHeaders() : Any

     
/**
* This endpoint causes the server to send custom set of response headers. Providing header values as part of the URL parameters of a `GET` request to this endpoint returns the same as part of response header.

To send your own set of headers, simply add or replace the the URL parameters with your own set.
* @param ContentType 
* @param test 
**/
@Headers()
@GET("{{baseURL}}/response-headers")
fun responseHeaders(@Query("Content-Type") ContentType : String, @Query("test") test : String) : Any

     
/**
* The HTTP `GET` request method is meant to retrieve data from a server. The data
is identified by a unique URI (Uniform Resource Identifier). 

A `GET` request can pass parameters to the server using "Query String 
Parameters". For example, in the following request,

> http://example.com/hi/there?hand=wave

The parameter "hand" has the value "wave".

This endpoint echoes the HTTP headers, request parameters and the complete
URI requested.
* @param test 
**/
@Headers()
@GET("{{baseURL}}/get")
fun getRequest(@Query("test") test : String) : Any

     
/**
* The HTTP `POST` request method is meant to transfer data to a server 
(and elicit a response). What data is returned depends on the implementation
of the server.

A `POST` request can pass parameters to the server using "Query String 
Parameters", as well as the Request Body. For example, in the following request,

> POST /hi/there?hand=wave
>
> <request-body>

The parameter "hand" has the value "wave". The request body can be in multiple
formats. These formats are defined by the MIME type of th
**/
@Headers()
@POST("{{baseURL}}/post")
fun postRequest() : Any

     
/**
* The HTTP `PUT` request method is similar to HTTP `POST`. It too is meant to 
transfer data to a server (and elicit a response). What data is returned depends on the implementation
of the server.

A `PUT` request can pass parameters to the server using "Query String 
Parameters", as well as the Request Body. For example, in the following 
raw HTTP request,

> PUT /hi/there?hand=wave
>
> <request-body>



**/
@Headers()
@PUT("{{baseURL}}/put")
fun putRequest() : Any

     
/**
* The HTTP `PATCH` method is used to update resources on a server. The exact
use of `PATCH` requests depends on the server in question. There are a number
of server implementations which handle `PATCH` differently. Technically, 
`PATCH` supports both Query String parameters and a Request Body.

This endpoint accepts an HTTP `PATCH` request and provides debug information
such as the HTTP headers, Query String arguments, and the Request Body.
**/
@Headers()
@PATCH("{{baseURL}}/patch")
fun patchRequest() : Any

     
/**
* The HTTP `DELETE` method is used to delete resources on a server. The exact
use of `DELETE` requests depends on the server implementation. In general, 
`DELETE` requests support both, Query String parameters as well as a Request 
Body.

This endpoint accepts an HTTP `DELETE` request and provides debug information
such as the HTTP headers, Query String arguments, and the Request Body.
**/
@Headers()
@DELETE("{{baseURL}}/delete")
fun deleteRequest() : Any

     
/**
* This endpoint allows one to instruct the server which status code to respond with.

Every response is accompanied by a status code. The status code provides a summary of the nature of response sent by the server. For example, a status code of `200` means everything is okay with the response and a code of `404` implies that the requested URL does not exist on server. 
A list of all valid HTTP status code can be found at the [List of Status Codes](https://en.wikipedia.org/wiki/List_of_HTTP_status_
**/
@Headers()
@GET("{{baseURL}}/status/200")
fun responseStatusCode() : Any

     
/**
* This endpoint allows one to recieve streaming http response using [chunked transfer encoding](https://en.wikipedia.org/wiki/Chunked_transfer_encoding) of a configurable length.

A streaming response does not wait for the entire response to be generated on server before flushing it out. This implies that for a fairly large response, parts of it can be streamed to the requestee as and when it is generated on server. The client can then take actions of processing this partially received data.
**/
@Headers()
@GET("{{baseURL}}/stream/10")
fun streamedResponse() : Any

     
/**
* Using this endpoint one can configure how long it takes for the server to come back with a response. Appending a number to the URL defines the time (in seconds) the server will wait before responding.

Note that a maximum delay of 10 seconds is accepted by the server.
**/
@Headers()
@GET("{{baseURL}}/delay/3")
fun delayResponse() : Any

     
/**
* If a response of an endpoint requires to send data beyond the basic English / ASCII character set, the `charset` parameter in the `Content-Type` response header defines the character encoding policy.

This endpoint returns an `UTF8` character encoded response body with text in various languages such as Greek, Latin, East Asian, etc. Postman can interpret the character encoding and use appropriate methods to display the character set in responses.
**/
@Headers()
@GET("{{baseURL}}/encoding/utf8")
fun getUtf8EncodedResponse() : Any

     
/**
* This endpoint returns the response using [gzip compression algoritm](https://en.wikipedia.org/wiki/Gzip).
The uncompressed response is a JSON string containing the details of the request sent by the client. For this endpoint to work, one should request with `Accept-encoding` header containing `gzip` as part of its value. Postman supports gzip, deflate and SDCH decoding and automatically sends them as part of the request.

HTTP Compression allows the server to send responses in a compressed forma
**/
@Headers()
@GET("{{baseURL}}/gzip")
fun gzipCompressedResponse() : Any

     
/**
* This endpoint returns the response using [deflate compression algoritm](https://en.wikipedia.org/wiki/DEFLATE). 
The uncompressed response is a JSON string containing the details of the request sent by the client. For this endpoint to work, one should request with `Accept-encoding` header containing `deflate` as part of its value. Postman supports gzip, deflate and SDCH decoding and automatically sends them as part of the request.

HTTP Compression allows the server to send responses in a compre
**/
@Headers()
@GET("{{baseURL}}/deflate")
fun deflateCompressedResponse() : Any

}