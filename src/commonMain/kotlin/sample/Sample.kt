package sample
import BaseClient.ApiMessage
import Accounts.AccountsResponse
import Accounts.GetAccountsTask
import Accounts.TestAccountsResponse
import kotlinx.coroutines.*


expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    fun name(): String
}

fun hello(): String = "Hello from ${Platform.name()}"
