package Accounts

import kotlinx.serialization.Serializable

@Serializable
data class AccountDateCreated (

    val _seconds : Long,
    val _nanoseconds : Long
)