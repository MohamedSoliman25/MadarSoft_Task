package com.example.madarsofttask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String?,
    val age:Int?,
    val jobTitle:String?,
    val gender:String?
)
