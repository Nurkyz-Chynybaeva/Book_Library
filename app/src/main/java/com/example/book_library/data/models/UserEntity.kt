package com.example.book_library.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    var id: Long,
    var name: String,
    var surname: String,
    var img: String
)