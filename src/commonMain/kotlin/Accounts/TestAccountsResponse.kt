package Accounts

import BaseClient.ApiMessage
import kotlinx.serialization.Serializable

@Serializable
data class TestAccountsResponse (

    val result : String,
    val data : List<Data>,
    val count : Long
) : ApiMessage()