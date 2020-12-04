package kz.nurtbayev.childcare.content.personal_informations.models

import com.google.gson.annotations.SerializedName

data class CityModel (
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("isActive")
        val isActive: Boolean
)