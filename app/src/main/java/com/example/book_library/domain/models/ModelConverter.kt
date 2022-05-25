package com.example.book_library.domain.models

import com.example.book_library.data.models.BookDto
import com.example.book_library.data.models.BookEntity

fun BookDto.toBookEntity(): BookEntity {

    return BookEntity(
//        objectId = this.objectId,
        id = this.id,
        name = this.name,
        surname = this.surname,
        image = this.image,
        book = this.book
    )
}