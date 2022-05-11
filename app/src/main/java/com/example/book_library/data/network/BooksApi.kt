package com.example.book_library.data.network

import com.example.book_library.data.models.UserDto
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {
    @GET("api/data/Ayim")
    fun getUsers(): Single<List<UserDto>>
}