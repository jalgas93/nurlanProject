package kz.nurtbayev.childcare.content.ui.likes.models


import com.google.gson.annotations.SerializedName

data class ArticleCategory(
    @SerializedName("code")
    val code: String,
    @SerializedName("hasSubcategory")
    val hasSubcategory: Any,
    @SerializedName("icon")
    val icon: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)