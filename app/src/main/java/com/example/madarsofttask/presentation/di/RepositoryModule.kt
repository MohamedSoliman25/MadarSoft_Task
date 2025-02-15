package com.example.madarsofttask.presentation.di

import com.example.madarsofttask.data.local.dao.UserDao
import com.example.madarsofttask.data.repository.UserRepositoryImp
import com.example.madarsofttask.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        dao: UserDao
    ): UserRepository {
        return UserRepositoryImp(dao)
    }
}
