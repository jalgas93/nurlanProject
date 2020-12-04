package kz.nurtbayev.childcare.sign_up

import android.app.Application
import kz.nurtbayev.childcare.common.remote.ApiConstants
import kz.nurtbayev.childcare.common.remote.Networking
import kz.nurtbayev.childcare.sign_up.models.SignUpRequest

class SignUpRepository(application: Application) {

    companion object {
        const val TAG = "SignUpRepository"
    }

    private val networkService =
        Networking.create(ApiConstants.APP_BASE_URL)

    suspend fun signUp(signUpRequest: SignUpRequest): String {
        val response = networkService.signUp(signUpRequest)
        return if (response.body()?.status=="success") {
            "OK"
        } else {
            response.body()?.error_description.toString()
        }
    }

}