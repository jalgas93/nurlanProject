package kz.nurtbayev.childcare.sign_in.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: UserModel
)