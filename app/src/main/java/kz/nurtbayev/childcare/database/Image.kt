package kz.nurtbayev.childcare.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
val hospitalSrc : Int,
val hospitaLoc : Int,
val hospitalTitle: String,
val hospitalDesc : String,
val hospitalAddress: String, //Address
val hospitalTelephone: String,
val hospitalType: String,
val hospitalUsluga: String,
val uslugaPrice: String
) : Parcelable
