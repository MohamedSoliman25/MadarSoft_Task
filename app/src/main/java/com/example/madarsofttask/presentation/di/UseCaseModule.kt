package com.example.madarsofttask.presentation.di

import com.example.madarsofttask.domain.repository.UserRepository
import com.example.madarsofttask.domain.usecase.SaveUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideSavingUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase {
        return SaveUserUseCase(userRepository)
    }
}