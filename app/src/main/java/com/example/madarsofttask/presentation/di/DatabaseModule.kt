package com.example.madarsofttask.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.madarsofttask.data.local.dao.UserDao
import com.example.madarsofttask.data.local.database.MadarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MadarDatabase {
        return Room.databaseBuilder(
            context,
            MadarDatabase::class.java,
            "madar_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: MadarDatabase): UserDao {
        return database.userDao()
    }
}
