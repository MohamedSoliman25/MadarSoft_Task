package com.example.madarsofttask.domain.usecase

import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(private val userRepository: UserRepository) {
     operator suspend fun invoke(user: User) {
        userRepository.insertUser(user)
    }
}