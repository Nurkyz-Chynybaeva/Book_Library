package com.example.book_library.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val results: List<BookEntity>
)

@Entity
data class BookEntity(
    @PrimaryKey
    var objectId: String,
    var id: Int? = null,
    var name: String? = null,
    var author: String? = null,
    var image: String? = null,
    var book: String? = null
)