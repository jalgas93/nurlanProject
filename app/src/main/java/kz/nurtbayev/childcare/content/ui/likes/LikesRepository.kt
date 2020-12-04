package kz.nurtbayev.childcare.content.ui.likes

import android.app.Application
import android.content.Context
import android.util.Log
import kz.nurtbayev.childcare.common.preferences.UserSession
import kz.nurtbayev.childcare.common.remote.ApiConstants
import kz.nurtbayev.childcare.common.remote.Networking
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleModel
import kz.nurtbayev.childcare.content.ui.likes.models.ArticleResponseModel
import retrofit2.Response

class LikesRepository() {

    companion object {
        const val TAG = "LikesRepository"
    }
//
    private val networkService =
        Networking.create(ApiConstants.APP_BASE_URL)
//    private var sharedPreferences =
//        application.getSharedPreferences("userSession", Context.MODE_PRIVATE)
//    private var userSession: UserSession =
//        UserSession(sharedPreferences)
//
    suspend fun getArticle(): Response<ArticleResponseModel>{
        return networkService.getArticles()
    }
//    suspend fun getArticleModel(): Response<ArticleModel>{
//        return networkService.getArticlesModel()
//    }

    suspend fun getArticles(): ArticleResponseModel? {
        return try {
            networkService.getArticles().body()
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            null
        }
    }

//    suspend fun getToken(): String {
//        return userSession.getAccessToken().toString()
//    }

}