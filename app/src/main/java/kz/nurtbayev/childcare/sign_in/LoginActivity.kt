package kz.nurtbayev.childcare.sign_in

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kz.nurtbayev.childcare.content.personal_informations.PersonalInformationActivity
import kz.nurtbayev.childcare.sign_in.models.AuthRequest
import kz.nurtbayev.childcare.sign_up.SignupActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "AuthorizeActivity"
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        lets()
    }

    private fun lets() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        sign_in_button.onClick { prepareLogin() }
        CreateAccount.onClick { startActivity(intentFor<SignupActivity>()) }
        observer()
    }

    private fun prepareLogin() {
        val login = inputEmail.text.toString()
        val password = inputPassword.text.toString()
        val tokenRequest =
            AuthRequest(
                password,
                login
            )
        logIn(tokenRequest)
    }

    private fun logIn(tokenRequest: AuthRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.signIn(tokenRequest)
        }
    }

    private fun observer() {
        viewModel.isError.observe(this, Observer {
            errorDialog(getString(R.string.error_unknown_body))
        })

        viewModel.isSuccess.observe(this, Observer {
            if (!it) {
                unSuccessFulDialog()
            } else {
                startActivity(intentFor<PersonalInformationActivity>())
                Toast.makeText(this, "Авторизация прошла успешно!", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun unSuccessFulDialog() {
        alert {
            title = getString(R.string.error_auth_wrong_data_title)
            message = getString(R.string.error_auth_wrong_data_msg)
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