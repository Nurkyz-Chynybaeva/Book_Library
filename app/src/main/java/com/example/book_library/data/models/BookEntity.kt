package com.example.book_library.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val results: List<BookEntity>
)

@Entity
data class BookEntity(
    @PrimaryKey
    var id: Long,
    var name: String,
    var surname: String,
    var image: String,
    var book: String
)