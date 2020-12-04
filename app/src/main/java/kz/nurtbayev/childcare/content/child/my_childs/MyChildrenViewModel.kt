package kz.nurtbayev.childcare.content.child.my_childs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.child.models.ChildrenResponse
import kz.nurtbayev.childcare.content.ui.hospitals.models.HospitalResponse
import retrofit2.Response

class MyChildrenViewModel(var repository: Repository): ViewModel() {

    var childrenLiveData: MutableLiveData<Response<ChildrenResponse>> = MutableLiveData()

    fun getChildren(){
        viewModelScope.launch {
            val response = repository.getChildren()
            childrenLiveData.value = response
        }
    }
}