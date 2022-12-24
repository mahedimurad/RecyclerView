package com.example.recylerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ecom(var itemImage: Int,
                var header: String,
                var description: String,
                var price: String
) : Parcelable