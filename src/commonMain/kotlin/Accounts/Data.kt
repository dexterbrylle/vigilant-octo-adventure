package Accounts

import Accounts.AccountDateCreated
import Accounts.AccountLastUpdated
import kotlinx.serialization.Serializable

@Serializable
data class Data (

    val currency : String,
    val bban : String,
    val initialBalance : Double,
    val accountDateCreated : AccountDateCreated,
    val accountLastUpdated : AccountLastUpdated,
    val accountId : Long,
    val accountOwner : String,
    val iban : String,
    val customerType : String,
    val postingsRestriction : String,
    val accountName : String,
    val accountStatus : String,
    val accountOwnership : String,
    val currentBalance : Double,
    val accountType : String
)