package kz.nurtbayev.childcare.content.ui.likes.models


import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("data")
    val `data`: List<ArticleData>,
    @SerializedName("status")
    val status: String
)