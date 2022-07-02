package com.example.book_library.data.network

import com.example.book_library.data.models.BookDto
import com.example.book_library.data.models.BookEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {

    @GET("api/data/name")
    fun getBooks(
        @Query("pageSize") size: Int = 20
    ): Single<List<BookDto>>

//    @GET("api/data/book_library?where=genres%3D'detective'")
//    fun getTechnicBooks(
//        @Query("pageSize") size: Int = 2
//    ):Single<List<BookEntity>>

    @GET("api/data/name/{objectId}")
    fun getBookById(@Path("objectId") objectId: String): Single<BookDto>
}