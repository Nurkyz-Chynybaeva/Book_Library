package com.example.book_library.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val results: List<BookEntity>
)

@Entity
data class BookEntity(
    @PrimaryKey
    var id: Long? = null,
    var name: String? = null,
    var surname: String? = null,
    var image: String? = null,
    var book: String? = null
)