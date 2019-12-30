package com.rmuhamed.params.app.client.viewobject

import android.os.Parcel
import android.os.Parcelable

data class Param(
    val name: String,
    val readableFromNonPaymentApp: Boolean,
    val editionOptions: EditionOptions,
    val format: Format,
    val config: ConfigurationViewObject
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt() == 1,
        EditionOptions.valueOf(parcel.readString()!!),
        Format.valueOf(parcel.readString()!!),
        parcel.readParcelable<ConfigurationViewObject>(ConfigurationViewObject::class.java.classLoader)!!
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            it.writeString(name)
            it.writeInt(if(readableFromNonPaymentApp) 1 else 0)
            it.writeString(editionOptions.name)
            it.writeString(format.name)
            it.writeParcelable(config, flags)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Param> {
        override fun createFromParcel(parcel: Parcel): Param {
            return Param(parcel)
        }

        override fun newArray(size: Int): Array<Param?> {
            return arrayOfNulls(size)
        }
    }
}

enum class EditionOptions {
    NON_EDITABLE,
    FREE_EDITION,
    PASSWORD_REQUIRED
}

enum class Format {
    ALPHANUMERIC,
    NUMERIC,
    NUMERIC_OR_BLANK,
    HEXADECIMAL,
    BINARY,
    IP_ADDRESS
}

fun Param.justReadOnly(): Boolean = this.editionOptions == EditionOptions.NON_EDITABLE

fun Param.passwordRequiredBeforeSave(): Boolean =
    this.editionOptions == EditionOptions.PASSWORD_REQUIRED

fun Param.canBeBlank(): Boolean = Format.NUMERIC_OR_BLANK == this.format

