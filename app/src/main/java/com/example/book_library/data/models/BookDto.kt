package com.example.book_library.data.models

data class ResponseDto(
    val results: List<BookDto>
)

data class BookDto(
//    var objectId: String,
    var id: Int? = null,
    var name: String? = null,
    var surname: String? = null,
    var image: String? = null,
    var book: String? = null
)