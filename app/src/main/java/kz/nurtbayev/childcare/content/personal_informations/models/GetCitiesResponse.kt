package kz.nurtbayev.childcare.content.personal_informations.models

import com.google.gson.annotations.SerializedName

data class GetCitiesResponse(
    @SerializedName("data")
    val data: List<CityModel>,
    @SerializedName("status")
    val status: String
)