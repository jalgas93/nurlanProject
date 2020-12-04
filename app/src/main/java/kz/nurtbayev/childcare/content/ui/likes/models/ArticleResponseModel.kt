package kz.nurtbayev.childcare.content.ui.likes.models

import com.google.gson.annotations.SerializedName

data class ArticleResponseModel (
@SerializedName("data")
val data: List<ArticleModel>,
@SerializedName("status")
val status: String
)