package com.example.recylerview

import android.os.Parcel
import android.os.Parcelable
import android.widget.Button

data class ecom(var itemImage: Int,
                var header: String,
                var description: String,
                var price: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(itemImage)
        parcel.writeString(header)
        parcel.writeString(description)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ecom> {
        override fun createFromParcel(parcel: Parcel): ecom {
            return ecom(parcel)
        }

        override fun newArray(size: Int): Array<ecom?> {
            return arrayOfNulls(size)
        }
    }
}