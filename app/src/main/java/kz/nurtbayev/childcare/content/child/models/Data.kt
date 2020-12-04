package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("disease")
    val disease: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("height")
    val height: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("parentId")
    val parentId: Int,
    @SerializedName("weight")
    val weight: Double
)