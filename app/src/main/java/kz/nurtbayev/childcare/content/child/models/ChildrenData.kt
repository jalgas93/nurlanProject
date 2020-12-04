package kz.nurtbayev.childcare.content.child.models


import com.google.gson.annotations.SerializedName

data class ChildrenData(
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("createdBy")
    val createdBy: Any,
    @SerializedName("createdDate")
    val createdDate: Any,
    @SerializedName("disease")
    val disease: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("height")
    val height: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastModifiedBy")
    val lastModifiedBy: Any,
    @SerializedName("lastModifiedDate")
    val lastModifiedDate: Any,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("parent")
    val parent: Parent,
    @SerializedName("weight")
    val weight: Double
)