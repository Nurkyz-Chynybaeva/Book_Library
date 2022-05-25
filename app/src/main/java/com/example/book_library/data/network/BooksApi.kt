package com.example.book_library.data.network

import com.example.book_library.data.models.BookDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {
    @GET("api/data/book_library")
    fun getBooks(
        @Query("pageSize") size: Int = 100
    ): Single<List<BookDto>>


    @GET("api/data/technic_books")
    fun getTechnicBooks(
        @Query("pageSize") size: Int = 100
    ): Single<List<BookDto>>


    @GET("api/data/book_library/{objectId}")
    fun getBookById(@Path("objectId") objectId: String): Single<BookDto>
}