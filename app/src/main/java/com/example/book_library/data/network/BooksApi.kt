package com.example.book_library.data.network

import com.example.book_library.data.models.BookDto
import io.reactivex.Single
import retrofit2.http.GET

interface BooksApi {
    @GET("api/data/Ayim2")
    fun getBooks(): Single<List<BookDto>>
}