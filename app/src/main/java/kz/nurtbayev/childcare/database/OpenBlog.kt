package kz.nurtbayev.childcare.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OpenBlog(
    val open_blogSrc : Int,
    val open_blogLike: Int,
    val open_blogTitle: String,
    val open_blogDesc : String

) : Parcelable