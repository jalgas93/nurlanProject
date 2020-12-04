package kz.nurtbayev.childcare.content.personal_informations

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.R
import kz.nurtbayev.childcare.content.personal_informations.models.CityModel
import kz.nurtbayev.childcare.content.child.add_new_child.AddChildActivity
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalData
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.json.JSONException

class PersonalInformationActivity : AppCompatActivity() {

    companion object {
        const val TAG = "PersonalInformationActivity"
    }

    private lateinit var viewModel: PersonalInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
        lets()
        addPregnant()
        addPregnant2()
    }
    private fun addPregnant(){

        val costumList = listOf("Вы в положений?","Да","Нет")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,costumList)
        input_position_spinner.adapter = adapter



        input_position_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){

            }

        }

    }

    private fun addPregnant2(){

        val costumList = listOf("Какой ваш срок?","0-4 месяца","4-6 месяца","6-12 месяца","3-6 лет")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,costumList)
        input_term_spinner.adapter = adapter

        input_term_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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

    private fun lets() {
            viewModel = ViewModelProvider(this).get(PersonalInformationViewModel::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getCities()
            }
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getOrganizations()
             }
            observer()
        p_next_button.onClick { startActivity(intentFor<AddChildActivity>()) }
    }

    @SuppressLint("LongLogTag")
    private fun observer() {
        viewModel.listOfCity.observe(this, Observer {
            if (it != null) {
                Log.d(TAG, it.toString())
                addCities(it)
            } else {
                errorDialog(getString(R.string.error_unknown_body))
            }
        })
        viewModel.listOfOrg.observe(this, Observer {
            if (it != null) {
                Log.d(TAG, it.toString())
                addOrg(it)
            } else {
                errorDialog(getString(R.string.error_unknown_body))
            }
        })
        viewModel.isError.observe(this, Observer {
            errorDialog(getString(R.string.error_unknown_body))
        })
    }

    private fun errorDialog(errorMsg: String) {
        alert {
            title = getString(R.string.error_unknown_title)
            message = errorMsg
            isCancelable = false
            positiveButton(getString(R.string.dialog_retry)) { dialog ->
                dialog.dismiss()
                lets()
            }
            negativeButton(getString(R.string.dialog_exit)) {
                finish()
            }
        }?.show()
    }

    private fun addCities(it: List<CityModel>) {
        setSpinnerCityContent(it)
    }

    private fun addOrg(it: List<HospitalData>) {
        setSpinnerOrgContent(it)
    }

    @SuppressLint("LongLogTag")
    private fun setSpinnerCityContent(
            cities: List<CityModel>
    ) {
        val answerList: ArrayList<String> = ArrayList()
        answerList.add("Ваш город")
        for (i in cities.indices) {
            try {
                answerList.add(cities[i].name.toString())
            } catch (e: JSONException) {
                Log.e(TAG, e.message.toString())
            }
        }
        setSpinnerCityAdapter(answerList)
    }

    private fun setSpinnerCityAdapter(
                cities: List<String>
        ) {
            val arrayAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            input_city.adapter = arrayAdapter

        }


    @SuppressLint("LongLogTag")
    private fun setSpinnerOrgContent(
            cities: List<HospitalData>
    ) {
        val answerList: ArrayList<String> = ArrayList()
        answerList.add("Ваша поликлиника")
        for (i in cities.indices) {
            try {
                answerList.add(cities[i].name.toString())
            } catch (e: JSONException) {
                Log.e(TAG, e.message.toString())
            }
        }
        setSpinnerOrgAdapter(answerList)
    }

    private fun setSpinnerOrgAdapter(
            cities: List<String>
    ) {
        val arrayAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        input_hospital.adapter = arrayAdapter
    }


}