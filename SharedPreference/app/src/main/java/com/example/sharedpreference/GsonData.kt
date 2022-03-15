package com.example.sharedpreference

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GsonData(var title: String, var deadline: String)  : Parcelable {
//    var a = mutableListOf<GsonData>(this.title, this.deadline)
}


