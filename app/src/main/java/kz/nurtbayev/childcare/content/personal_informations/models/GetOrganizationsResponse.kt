package kz.nurtbayev.childcare.content.personal_informations.models

import com.google.gson.annotations.SerializedName

data class GetOrganizationsResponse(
    @SerializedName("data")
    val data: List<OrganizationsModel>,
    @SerializedName("status")
    val status: String
)