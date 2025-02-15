package com.example.madarsofttask.domain.usecase

import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(): List<User> = repository.getAllUsers()
}