package com.example.sharedpreference

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GsonData(var title: String, var deadline: String)  : Parcelable