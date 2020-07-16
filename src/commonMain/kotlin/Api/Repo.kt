package Api

import Api.GetAllAccounts

class ApiRepo(private val api: GetAllAccounts) {
    suspend fun get(): String {
        return api.getAccounts()
    }
}