package kz.nurtbayev.childcare.content.child.add_new_child

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_child.*
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.common.preferences.UserSession
import kz.nurtbayev.childcare.content.child.my_childs.MyChildrenActivity

class ChildActivity : AppCompatActivity() {

    private lateinit var addChildViewModel: CreateChildViewModel
    private lateinit var addChildFactory: CreateChildFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        setupViewshome()
        init()
        addPregnant2()
    }


    private fun addPregnant2(){

        val costumList = listOf("Выберите пол","Мужской","Женский")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,costumList)
        et_gender.adapter = adapter

        et_gender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }

        }

    }


    private fun setupViewshome() {
        go_to_homepage.setOnClickListener {

            val birthdate = et_birthday.text.toString()
//            val gender = et_gender.text.toString()
            val nickname = et_nickname.text.toString()
            val disease = input_term.text.toString()

            addChildViewModel.createChild(birthdate,disease,"asf",0,11,nickname,0,0)
            addChildViewModel.childLiveData.observe(this, Observer {
                Log.i("CreateChild",it.body()?.data.toString())
            })
            val intent = Intent(this, MyChildrenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        val repository = Repository()
        addChildFactory = CreateChildFactory(repository)
        addChildViewModel = ViewModelProvider(this,addChildFactory).get(CreateChildViewModel::class.java)
    }
}