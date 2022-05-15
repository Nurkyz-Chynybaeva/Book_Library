package com.example.book_library.di

import android.app.Application
import androidx.room.Room
import com.example.book_library.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) = appDatabase.booksDao()

    @Provides
    @Singleton
    fun provideAppDatabase(context: Application) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}