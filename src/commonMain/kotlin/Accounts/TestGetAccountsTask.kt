package Accounts

import Accounts.TestAccountsResponse
import BaseClient.ApiMessage
import BaseClient.BaseClientApi
import kotlinx.serialization.KSerializer

class TestGetAccountsTask: BaseClientApi() {

    override var apiSerializer: KSerializer<out ApiMessage>
        get() = TestAccountsResponse.serializer()
        set(value) {}

    override val endpoint: String
        get() = "accounts/qk4ulazL38o3pQY5h54T/all"
}