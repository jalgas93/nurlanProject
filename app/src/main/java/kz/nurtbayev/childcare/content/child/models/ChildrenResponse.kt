package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class ChildrenResponse(
    @SerializedName("data")
    val data: List<ChildrenData>,
    @SerializedName("status")
    val status: String
)