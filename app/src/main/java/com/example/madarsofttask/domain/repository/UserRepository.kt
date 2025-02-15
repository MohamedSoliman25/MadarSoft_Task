package com.example.madarsofttask.domain.repository

import com.example.madarsofttask.data.local.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
     suspend fun insertUser(user: User):Boolean
     suspend fun getAllUsers(): List<User>
}