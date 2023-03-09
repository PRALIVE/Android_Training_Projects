package com.example.multistepform.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var primaryKey : Int=0,
    @ColumnInfo(name = "firstName")var firstName: String = "",
    @ColumnInfo(name = "secondName")var secondName: String = "",
    @ColumnInfo(name = "email")var email: String = "",
    @ColumnInfo(name = "phone")var phone: String = "",
    @ColumnInfo(name = "address1")var address1: String = "",
    @ColumnInfo(name = "address2")var address2: String = "",
    @ColumnInfo(name = "address3")var address3: String = ""
)