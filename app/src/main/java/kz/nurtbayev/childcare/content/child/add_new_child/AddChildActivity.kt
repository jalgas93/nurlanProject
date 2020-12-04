package kz.nurtbayev.childcare.content.child.add_new_child

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_addchild.*
import kotlinx.android.synthetic.main.activity_child.*
import kotlinx.android.synthetic.main.activity_personal_information.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.common.Repository
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class AddChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addchild)
        lets()
    }

    private fun lets() {
        add_child_btn.onClick {
            startActivity(intentFor<ChildActivity>())
        }
//        add_child_skip.onClick { startActivity(intentFor<HomeActivity>()) }
    }
}