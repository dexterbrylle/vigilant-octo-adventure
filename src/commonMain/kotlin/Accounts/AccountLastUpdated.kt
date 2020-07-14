package Accounts

import kotlinx.serialization.Serializable

@Serializable
data class AccountLastUpdated (

    val _seconds : Long,
    val _nanoseconds : Long
)