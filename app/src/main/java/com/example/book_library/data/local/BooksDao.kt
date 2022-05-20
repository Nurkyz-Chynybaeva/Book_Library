package com.example.book_library.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.book_library.data.models.BookEntity
import io.reactivex.Single

@Dao
interface BooksDao {

    @Query("SELECT * FROM BookEntity")
    fun getAll(): LiveData<List<BookEntity>>

//    @Query("SELECT * FROM BookEntity WHERE id = :id")
//    fun getById(id: Long?): Single<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(booksList: List<BookEntity>)

}