package com.example.madarsofttask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.madarsofttask.data.local.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertUser(user: User):Long
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>
}