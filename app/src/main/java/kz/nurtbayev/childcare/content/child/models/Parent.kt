package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: City,
    @SerializedName("createdBy")
    val createdBy: Any,
    @SerializedName("createdDate")
    val createdDate: Any,
    @SerializedName("email")
    val email: String,
    @SerializedName("favouriteList")
    val favouriteList: List<Any>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isPregnant")
    val isPregnant: Boolean,
    @SerializedName("lastModifiedBy")
    val lastModifiedBy: Any,
    @SerializedName("lastModifiedDate")
    val lastModifiedDate: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("polyclinic")
    val polyclinic: Polyclinic,
    @SerializedName("pregnancyWeekCount")
    val pregnancyWeekCount: Int,
    @SerializedName("roles")
    val roles: List<Role>,
    @SerializedName("signupToken")
    val signupToken: String
)