package kz.nurtbayev.childcare.content.ui.likes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleModel

//class LikesViewModel(application: Application) : AndroidViewModel(application) {
//
//    companion object {
//        const val TAG = "LikesViewModel"
//    }
//
//    val articleList: MutableLiveData<List<ArticleModel>> = MutableLiveData()
//    val isError: MutableLiveData<String> = MutableLiveData()
//
////    private val repository: LikesRepository = LikesRepository(application)
//
//    private fun loadPage() {
//        viewModelScope.launch {
//            try {
//                val response = repository.getArticles()
//                if (response != null) {
//                    articleList.postValue(response.data)
//                }
//            } catch (e: Exception) {
//                isError.postValue(null)
//                Log.e(TAG, e.message.toString())
//            }
//        }
//    }
//
//}