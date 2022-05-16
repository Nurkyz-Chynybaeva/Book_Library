package com.example.book_library.data.repo

import com.example.book_library.data.local.BooksDao
import com.example.book_library.data.models.BookDto
import com.example.book_library.data.models.BookEntity
import com.example.book_library.data.network.BooksApi
import io.reactivex.Single
import javax.inject.Inject

class BookRepo @Inject constructor(
    private var booksDao: BooksDao,
    private var booksApi: BooksApi,
) {

    fun getAllBooks(): Single<List<BookDto>> {
        return booksApi.getBooks()
    }

    fun insertList(characterList: List<BookEntity>) {
        booksDao.insertList(characterList)
    }

//    fun getUserFromApi() = userApi.getUsers()
//        .subscribeOn(Schedulers.io())

    fun getBooksAsLiveData() = booksDao.getAll()
}