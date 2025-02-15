package com.example.madarsofttask.domain.repository

import com.example.madarsofttask.data.local.entity.User

interface UserRepository {
     suspend fun insertUser(user: User)
}