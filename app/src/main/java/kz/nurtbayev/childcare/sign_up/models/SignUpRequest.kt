package kz.nurtbayev.childcare.sign_up.models

import com.google.gson.annotations.SerializedName

data class  SignUpRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String
)