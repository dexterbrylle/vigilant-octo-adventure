package Presenter

import Api.Background
import Api.Main
import Domain.CaseProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccountsPresenter(private val view: AccountView) {
    private val case = CaseProvider.getCase()

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val s = case.get()
                println(s)
                withContext(Main) {
                    view.showState(AccountState(s))
                }
            }
        }
    }
}