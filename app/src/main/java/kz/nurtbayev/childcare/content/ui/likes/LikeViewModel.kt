package kz.nurtbayev.childcare.content.ui.likes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleModel
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleResponse
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleResponseModel
import retrofit2.Response

class LikeViewModel(var repository: LikesRepository): ViewModel() {
    var likeLiveData: MutableLiveData<Response<ArticleResponseModel>> = MutableLiveData()
    var articleLiveData: MutableLiveData<Response<ArticleModel>> = MutableLiveData()

    fun getLike(){
        viewModelScope.launch {
            var response = repository.getArticle()
            likeLiveData.value = response
        }
    }
//    fun getArticle(){
//        viewModelScope.launch {
//            var response = repository.getArticleModel()
//            articleLiveData.value = response
//        }
//    }
}