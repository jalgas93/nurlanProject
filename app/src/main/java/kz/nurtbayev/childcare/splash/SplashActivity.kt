package kz.nurtbayev.childcare.splash


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kz.nurbayev.akniet.common.helpers.GeneralHelper
import kz.nurtbayev.childcare.HomeActivity
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.FoundationActivity
import kz.nurtbayev.childcare.sign_in.LoginActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor

class SplashActivity : AppCompatActivity() {

    companion object {
        const val TAG = "SplashActivity"
    }

    private lateinit var viewModel: SplashViewModel
    private val mContext = this
    private var isFirstLaunch = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lets()
        observer()
    }


    private fun lets() {
        GeneralHelper.hideStatusBar(this)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        CoroutineScope(Dispatchers.IO).launch { checkNetwork() }
    }

    private fun observer() {
        viewModel.isNetworkConnection.observe(mContext, Observer {
            if (it) {
                checkAuthorize()
            } else {
                showNetworkDialogue()
            }
        })
        viewModel.isAuthorize.observe(mContext, Observer {
            finish()
            if (it) {
                startActivity(intentFor<FoundationActivity>())
            } else {
                startActivity(intentFor<LoginActivity>())
            }
        })

    }



    private fun checkAuthorize() {
        viewModel.checkAuthorize()
    }


    private suspend fun checkNetwork() {
        if (isFirstLaunch) {
            delay(2000L)
            isFirstLaunch = false
        }
        viewModel.checkNetwork(mContext)
    }

    private fun showNetworkDialogue() {
        alert {

            isCancelable = false
            title = getString(R.string.error_no_internet_title)
            message = getString(R.string.error_no_internet_msg)
            negativeButton(getString(R.string.dialog_exit)) {

                finish()
            }
            positiveButton(getString(R.string.dialog_retry)) {
                it.dismiss()
                onRestart()
            }
        }.show()
    }

    override fun onRestart() {
        super.onRestart()
        CoroutineScope(Dispatchers.IO).launch {
            checkNetwork()
        }
    }
}