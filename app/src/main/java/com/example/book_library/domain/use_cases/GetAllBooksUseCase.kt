package com.example.book_library.domain.use_cases

import com.example.book_library.data.models.BookEntity
import com.example.book_library.data.repo.BookRepo
import com.example.book_library.domain.models.toBookEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(
    private val bookRepo: BookRepo,
) {
    operator fun invoke(): Single<List<BookEntity>> {
        return bookRepo.getAllBooks()
            .subscribeOn(Schedulers.io())
            .map {
                it
            }
            .map {
                val listDB = mutableListOf<BookEntity>()
                it.forEach {
                    listDB.add(it.toBookEntity())
                }
                listDB.toList()
            }
            .map {
                bookRepo.insertList(it)
               it
            }
            .observeOn(AndroidSchedulers.mainThread())

    }
}

