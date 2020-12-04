package kz.nurtbayev.childcare.content.personal_informations

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.content.personal_informations.models.CityModel
import kz.nurtbayev.childcare.content.personal_informations.models.OrganizationsModel
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalData
import java.lang.Exception

class PersonalInformationViewModel(application: Application): AndroidViewModel(application) {

    companion object {
        const val TAG = "PersonalInformationViewModel"
    }

    private var repository: PersonalInformationRepository =
            PersonalInformationRepository(
                    application
            )

    val listOfCity: MutableLiveData<List<CityModel>> = MutableLiveData()
    val listOfOrg: MutableLiveData<List<HospitalData>> = MutableLiveData()
    val isError: MutableLiveData<String> = MutableLiveData()

    @SuppressLint("LongLogTag")
    fun getCities() {
        viewModelScope.launch {
            try {
                val result = repository.getCities()
                Log.e(TAG, result.toString())
                if (result!=null) {
                    listOfCity.postValue(result)
                } else {
                    isError.postValue(null)
                }
            } catch (exception: Exception) {
                Log.e(TAG, exception.message.toString())
                isError.postValue(exception.toString())
            }
        }
    }

    @SuppressLint("LongLogTag")
    fun getOrganizations() {
        viewModelScope.launch {
            try {
                val result = repository.getOrganizations()
                Log.e(TAG, result.toString())
                if (result!=null) {
                    listOfOrg.postValue(result)
                } else {
                    isError.postValue(null)
                }
            } catch (exception: Exception) {
                Log.e(TAG, exception.message.toString())
                isError.postValue(exception.toString())
            }
        }
    }

}