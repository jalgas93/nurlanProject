package kz.nurtbayev.childcare.sign_in

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kz.nurtbayev.childcare.sign_in.models.AuthRequest
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(application: Application): AndroidViewModel(application) {

    companion object {
        const val TAG = "LoginViewModel"
    }

    private var loginRepository: LoginRepository =
        LoginRepository(
            application
        )

    val isSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val isError: MutableLiveData<String> = MutableLiveData()

    fun signIn(authRequest: AuthRequest) {
        viewModelScope.launch {
            try {
                val result = loginRepository.logIn(authRequest)
                isSuccess.postValue(result)
            } catch (exception: Exception) {
                Log.e(TAG, exception.message.toString())
                isError.postValue(exception.toString())
            }
        }
    }
}