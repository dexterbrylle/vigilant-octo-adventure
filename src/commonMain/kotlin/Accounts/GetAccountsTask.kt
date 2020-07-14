package Accounts

import BaseClient.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

class GetAccountsTask : BaseClientApi() {
    override var apiSerializer: KSerializer<out ApiMessage>
        get() = AccountsResponse.serializer()
        set(value) {}

    override val endpoint: String
        get() = "accounts/qk4ulazL38o3pQY5h54T/all"
}
