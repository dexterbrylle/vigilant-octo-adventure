package Accounts

import BaseClient.ApiMessage
import kotlinx.serialization.*
import kotlinx.serialization.Serializable

@Serializable
data class AccountsResponse(
    val accounts: Accounts
) : ApiMessage()

@Serializable
data class Accounts (
    val result: String,
    val data: List<Datum>,
    val count: Long
)

@Serializable
data class Datum (
    val currentBalance: String,
    val accountType: String,
    val currency: String,
    val bban: String,
    val initialBalance: String,
    val accountDateCreated: AccountDateCreated,
    val accountLastUpdated: AccountLastUpdated,

    @SerialName("accountId")
    val accountID: Long,

    val accountOwner: String,
    val iban: String,
    val customerType: String,
    val postingsRestriction: String,
    val accountName: String,
    val accountStatus: String,
    val accountOwnership: String
)
