package kz.nurtbayev.childcare.content.ui.hospitals.models


import com.google.gson.annotations.SerializedName

data class HospitalResponse(
    @SerializedName("data")
    val data: List<HospitalData>,
    @SerializedName("status")
    val status: String
)