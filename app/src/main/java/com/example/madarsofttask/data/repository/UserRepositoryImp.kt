package com.example.madarsofttask.data.repository

import com.example.madarsofttask.data.local.dao.UserDao
import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class UserRepositoryImp @Inject constructor(private val userDao: UserDao) :UserRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user)>0

    override suspend fun getAllUsers() = userDao.getAllUsers()
}