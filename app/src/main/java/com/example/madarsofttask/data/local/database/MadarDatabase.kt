package com.example.madarsofttask.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.madarsofttask.data.local.dao.UserDao
import com.example.madarsofttask.data.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MadarDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}