package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class CityX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String
)