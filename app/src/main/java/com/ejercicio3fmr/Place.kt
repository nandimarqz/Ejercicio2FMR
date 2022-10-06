package com.ejercicio3fmr

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Place (val urlImg : String, val name : String, val lat : String , val lon : String):Parcelable {
}