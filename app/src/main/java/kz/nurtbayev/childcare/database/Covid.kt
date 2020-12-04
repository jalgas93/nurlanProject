package kz.nurtbayev.childcare.database
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Covid(
     val covidSrc : Int,
     val covidLike: Int,
     val covidTitle: String,
     val covidDesc : String
) : Parcelable