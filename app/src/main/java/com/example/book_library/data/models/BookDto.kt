package com.example.book_library.data.models

data class ResponseDto(
    val results: List<BookDto>
)

data class BookDto(
    var id: Int? = null,
    var objectId: String,
    var name: String? = null,
    var author: String? = null,
    var image: String? = null,
    var book: String? = null
)