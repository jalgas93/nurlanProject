package kz.nurtbayev.childcare.content.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.common.Repository
import kz.nurtbayev.childcare.content.ui.home.models.CategoriesResponse
import retrofit2.Response

class CategoriesVIewModel(var repository: Repository): ViewModel() {
    var categoriesLiveData:MutableLiveData<Response<CategoriesResponse>> = MutableLiveData()

    fun getCategories(){
        viewModelScope.launch {
            var response = repository.getCategories()
            categoriesLiveData.value = response
        }
    }
}