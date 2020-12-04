package kz.nurtbayev.childcare.content.ui.hospitals.models


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("code")
    val code: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String
)