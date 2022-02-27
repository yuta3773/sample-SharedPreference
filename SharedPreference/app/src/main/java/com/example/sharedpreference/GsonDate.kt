package com.example.sharedpreference

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
//class GsonDate(var title: String, var deadline: String)  : Parcelable {
class GsonDate() : Parcelable {
    var title: String = ""
    var deadline: String = ""
}