package Presenter

data class AccountState(val s: String)

interface AccountView {
    fun showState(state: AccountState)
}