package kz.nurtbayev.childcare.content.ui.calendar.models


import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("data")
    val `data`: List<Any>,
    @SerializedName("status")
    val status: String
)