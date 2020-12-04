package kz.nurtbayev.childcare.content.child.add_new_child

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.child.models.AddNewChildResponse
import retrofit2.Response

class CreateChildViewModel(var repository: Repository): ViewModel() {
    var childLiveData: MutableLiveData<Response<AddNewChildResponse>> = MutableLiveData()

    fun createChild(birthDate: String,disease: String,gender: String,height: Int,id:Int,nickname:String,parentId: Int,weight:Int){
        viewModelScope.launch {
            var response = repository.createChild(birthDate = birthDate,disease = disease,gender = gender,height = height,id = id,nickname = nickname,parentId = parentId,weight = weight)
            childLiveData.value = response
        }
    }
}