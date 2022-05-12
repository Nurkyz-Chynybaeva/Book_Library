package com.example.book_library.extensions

import com.example.book_library.data.models.UserDto
import com.example.book_library.data.models.UserEntity

fun UserDto.toCharacterEntity(): UserEntity {

    return UserEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        image = this.image
    )
}