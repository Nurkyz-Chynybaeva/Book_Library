package com.example.book_library.extensions

import com.example.book_library.data.models.BookDto
import com.example.book_library.data.models.BookEntity

fun BookDto.toDataEntity(): BookEntity {

    return BookEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        image = this.image,
        book = this.book
    )
}