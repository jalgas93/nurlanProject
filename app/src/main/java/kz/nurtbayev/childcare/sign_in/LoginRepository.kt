package kz.nurtbayev.childcare.sign_in

import android.app.Application
import android.content.Context
import kz.nurtbayev.childcare.common.preferences.UserSession
import kz.nurtbayev.childcare.common.remote.ApiConstants
import kz.nurtbayev.childcare.common.remote.Networking
import kz.nurtbayev.childcare.sign_in.models.AuthRequest

class LoginRepository(application: Application) {

    companion object {
        const val TAG = "LoginRepository"
    }

    private val networkService =
        Networking.create(ApiConstants.APP_BASE_URL)
    private var sharedPreferences =
        application.getSharedPreferences("userSession", Context.MODE_PRIVATE)
    private var userSession: UserSession =
        UserSession(sharedPreferences)

    suspend fun logIn(authRequest: AuthRequest): Boolean {
        val response = networkService.signIn(authRequest)
        return if (response.body()?.status=="success") {
            if (saveUserToken(response.body()?.data?.token.toString())) {
                saveUserInfo(response.body()?.data?.user!!.id, response.body()?.data?.user!!.email)
            } else {
                userSession.clear()
                false
            }
        } else {
            userSession.clear()
            false
        }
    }

    private fun saveUserInfo(id: Int, email: String): Boolean {
        userSession.setId(id)
        userSession.setEmail(email)
        return true
    }

    private fun saveUserToken(accessToken: String): Boolean {
        userSession.setAccessToken(accessToken)
        userSession.setIsAuthorize(true)
        return true
    }

}