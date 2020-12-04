package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class Polyclinic(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: CityX,
    @SerializedName("icon")
    val icon: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("info")
    val info: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("type")
    val type: Type
)