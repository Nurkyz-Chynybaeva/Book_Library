package com.example.book_library.data.models

data class ResponseDto(
    val results: List<UserDto>
)

data class UserDto(
    var id: Long,
    var name: String,
    var surname: String,
    var image: String,
    var book: String
)