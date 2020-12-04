package kz.nurtbayev.childcare.content.ui.hospitals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalResponse
import retrofit2.Response

class HospitalsViewModel(var repository: Repository): ViewModel() {
    var hospitalLiveData: MutableLiveData<Response<HospitalResponse>> = MutableLiveData()

    fun getHospital(){
        viewModelScope.launch {
            val response = repository.getHospital()
            hospitalLiveData.value = response
        }
    }
}