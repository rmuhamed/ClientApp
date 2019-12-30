package com.rmuhamed.params.app.client.viewobject

import android.os.Parcel
import android.os.Parcelable

data class ConfigurationViewObject(val minLength: Int = 0, val maxLength: Int, val defaultValue: String? = null) :
    Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readInt(), parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(minLength)
        parcel.writeInt(maxLength)
        parcel.writeString(defaultValue)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ConfigurationViewObject> {
        override fun createFromParcel(parcel: Parcel): ConfigurationViewObject {
            return ConfigurationViewObject(parcel)
        }

        override fun newArray(size: Int): Array<ConfigurationViewObject?> {
            return arrayOfNulls(size)
        }
    }
}