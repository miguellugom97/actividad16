package com.miguellugo.actividad16.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    val name: String? = null,
    val description: String? = null,
    val image: String? = null
) : Parcelable
