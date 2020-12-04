package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class AddNewChildResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("status")
    val status: String
)