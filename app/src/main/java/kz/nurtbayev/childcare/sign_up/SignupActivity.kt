package kz.nurtbayev.childcare.sign_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.sign_in.LoginActivity
import kz.nurtbayev.childcare.sign_up.models.SignUpRequest
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class SignupActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SignUpActivity"
    }

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        lets()
    }

    private fun lets() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        sign_up_button.onClick { signUp() }
        singIn.onClick { startActivity(intentFor<LoginActivity>()) }
        observer()
    }

    private fun signUp() {
        val name = inputName.text.toString()
        val inputphone = inputphone.text.toString()
        val inputEmail = inputEmail_su.text.toString()
        val inputPassword = inputPassword_su.text.toString()
        val confirmPassword = confirmPassword.text.toString()

        if (inputPassword == confirmPassword){
            val signUpRequest =
                SignUpRequest(inputEmail,name, inputPassword, inputphone)
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.signUp(signUpRequest)
            }
        } else {
            Toast.makeText(this, "Введенные вами пароли не совпадают!", Toast.LENGTH_LONG).show()
        }

    }


    private fun observer() {
        viewModel.isError.observe(this, Observer {
            errorDialog(it)
        })

        viewModel.isSuccess.observe(this, Observer {
            if (!it) {
                unSuccessFulDialog()
            } else {
                startActivity(intentFor<LoginActivity>())
                Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun unSuccessFulDialog() {
        alert {
            title = getString(R.string.error_su_wrong_data_title)
            message = getString(R.string.error_su_wrong_data_msg)
            isCancelable = false
            positiveButton(getString(R.string.dialog_retry)) { dialog ->
                dialog.dismiss()
            }
            negativeButton(getString(R.string.dialog_exit)) {
                finish()
            }
        }.show()
    }

    private fun errorDialog(errorMsg: String) {
        alert {
            title = getString(R.string.error_unknown_title)
            message = errorMsg
            isCancelable = false
            positiveButton(getString(R.string.dialog_retry)) { dialog ->
                dialog.dismiss()
            }
            negativeButton(getString(R.string.dialog_exit)) {
                finish()
            }
        }.show()
    }

}