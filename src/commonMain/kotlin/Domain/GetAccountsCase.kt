package Domain

import Api.GetAllAccounts
import Api.ApiRepo

class ApiCase(private val apiRepo: ApiRepo) {
    suspend fun get(): String {
        return apiRepo.get()
    }
}

object CaseProvider {
    fun getCase() = ApiCase(ApiRepo(GetAllAccounts()))
}