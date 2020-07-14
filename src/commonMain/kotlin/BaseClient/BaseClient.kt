package BaseClient

import Accounts.AccountsResponse
import Accounts.TestAccountsResponse

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.defaultSerializer
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

open class BaseClientApi() {

    open val endpoint = ""
    open val type = "POST"
    open var apiSerializer: KSerializer<out ApiMessage> = PolymorphicSerializer(
        ApiMessage::class)

    val BASE_URL = "https://us-central1-deh-dmb-api.cloudfunctions.net/dehAPI/"


    private val urlString = BASE_URL + endpoint
    private val jsonFormatter = Json(context = messageModule)


    private val client by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = defaultSerializer()
            }
        }
    }

    /**
     * Api Service call
     * @return Response object implementation of [ApiMessage] which depends on expected [apiSerializer]
     */
    open suspend fun callService(request: @Polymorphic ApiMessage): ApiMessage {
        val message = if (type == "POST") postMessage(request) else getMessage(request)
        return jsonFormatter.parse(apiSerializer, postMessage(request))
    }

    /**
     * Api Service call
     * @return Response object implementation of [ApiMessage] which depends on expected [apiSerializer]
     */
    open suspend fun callGetAccountsService(): ApiMessage {
        return jsonFormatter.parse(apiSerializer, getMessage())
    }

    private suspend fun postMessage(message: @Polymorphic ApiMessage): String {
        return client.post {
            url(urlString)
            val jsonData = jsonFormatter.stringify(PolymorphicSerializer(ApiMessage::class), message)
            body = TextContent(jsonData, contentType = ContentType.Application.Json)
        }
    }

    private suspend fun getMessage(): String {
        return client.get(urlString)
    }

    private suspend fun getMessage(message: @Polymorphic ApiMessage): String {
        return client.get {
            url(urlString)
            val jsonData = jsonFormatter.stringify(PolymorphicSerializer(ApiMessage::class), message)
            body = TextContent(jsonData, contentType = ContentType.Application.Json)
        }
    }
    companion object {
        val messageModule = SerializersModule {
            polymorphic(ApiMessage::class) {
                AccountsResponse:: class with AccountsResponse.serializer()
                TestAccountsResponse:: class with TestAccountsResponse.serializer()
            }
        }
    }
}

/**
Base class for API Request and Response
 */
@Serializable
abstract class ApiMessage