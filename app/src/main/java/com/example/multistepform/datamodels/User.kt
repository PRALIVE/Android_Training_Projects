package com.example.multistepform.datamodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@Entity
data class User(
    @PrimaryKey var primaryKey : Int=0,
    @ColumnInfo(name = "firstname")var firstname: String = "",
    @ColumnInfo(name = "secondname")var secondname: String = "",
    @ColumnInfo(name = "email")var email: String = "",
    @ColumnInfo(name = "phone")var phone: String = "",
    @ColumnInfo(name = "address1")var address1: String = "",
    @ColumnInfo(name = "address2")var address2: String = "",
    @ColumnInfo(name = "address3")var address3: String = ""
)