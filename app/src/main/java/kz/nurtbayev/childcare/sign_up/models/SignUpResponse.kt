package kz.nurtbayev.childcare.sign_up.models

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("error_description")
    val error_description: String
)