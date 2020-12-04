package kz.nurtbayev.childcare.content.ui.likes.models

import com.google.gson.annotations.SerializedName

data class ArticleModel (
    @SerializedName("categoryList")
        val categoryList: List<ArticleCategory>,
    @SerializedName("icon")
        val icon: Any,
    @SerializedName("id")
        val id: Int,
    @SerializedName("isFavourite")
        val isFavourite: Boolean,
    @SerializedName("text")
        val text: String,
    @SerializedName("topic")
        val topic: String
)