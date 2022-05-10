package com.example.book_library.data.local

import androidx.room.Dao
import androidx.room.Insert
import com.example.book_library.data.models.UserEntity
import io.reactivex.Completable

@Dao
interface UserDao {
    @Insert
    fun insertUsers(user: List<UserEntity>): Completable
}