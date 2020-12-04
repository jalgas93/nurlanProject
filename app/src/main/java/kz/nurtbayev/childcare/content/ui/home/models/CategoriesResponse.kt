package kz.nurtbayev.childcare.content.ui.home.models


import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("data")
    val data: List<CategoriesData>,
    @SerializedName("status")
    val status: String
)