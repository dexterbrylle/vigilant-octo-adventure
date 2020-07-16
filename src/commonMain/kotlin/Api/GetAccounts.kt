package Api

import Accounts.AccountsResponse
import Accounts.GetAccountsTask
import Accounts.TestAccountsResponse
import BaseClient.ApiMessage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class GetAllAccounts {
    private val client = HttpClient()

    private var address = Url("https://us-central1-deh-dmb-api.cloudfunctions.net/dehAPI/accounts/qk4ulazL38o3pQY5h54T/all")
    suspend fun getAccounts(): String {
        val json = Json(JsonConfiguration.Stable)
        return json.parse(AccountsResponse.serializer(),
            client.get(address)
        ).toString()
    }
}