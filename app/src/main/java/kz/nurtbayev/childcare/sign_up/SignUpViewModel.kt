package kz.nurtbayev.childcare.sign_up

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kz.nurtbayev.childcare.sign_up.models.SignUpRequest
import kotlinx.coroutines.launch
import java.lang.Exception

class SignUpViewModel(application: Application): AndroidViewModel(application) {

    companion object {
        const val TAG = "SignUpViewModel"
    }

    private var signUpRepository: SignUpRepository =
        SignUpRepository(
            application
        )

    val isSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val isError: MutableLiveData<String> = MutableLiveData()

    fun signUp(signUpRequest: SignUpRequest) {
        viewModelScope.launch {
            try {
                val result = signUpRepository.signUp(signUpRequest)
                if (result=="OK"){
                    isSuccess.postValue(true)
                } else {
                    isError.postValue(result)
                }

            } catch (exception: Exception) {
                Log.e(TAG, exception.message.toString())
                isError.postValue(exception.toString())
            }
        }
    }
}