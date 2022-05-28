package com.example.book_library.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.book_library.data.models.BookEntity

@Database(entities = [BookEntity::class], version = 7)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun booksDao(): BooksDao

    companion object {
        const val DB_NAME = "example.db"
    }
}