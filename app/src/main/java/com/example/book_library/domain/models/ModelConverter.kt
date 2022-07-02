package com.example.book_library.domain.models

import com.example.book_library.data.models.BookDto
import com.example.book_library.data.models.BookEntity

fun BookDto.toBookEntity(): BookEntity {

    return BookEntity(
        objectId = this.objectId,
        name = this.name,
        author = this.author,
        image = this.image,
        book = this.book
    )
}
