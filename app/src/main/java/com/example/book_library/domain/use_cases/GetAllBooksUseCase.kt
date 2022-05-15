package com.example.book_library.domain.use_cases

import com.example.book_library.data.models.BookEntity
import com.example.book_library.data.repo.BookRepo
import com.example.book_library.extensions.toDataEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(
    private val bookRepo: BookRepo,
) {
    operator fun invoke(): Single<Unit> {
        return bookRepo.getAllBooks()
            .subscribeOn(Schedulers.io())
            .map {
                val listDB = mutableListOf<BookEntity>()
                it.forEach {
                    listDB.add(it.toDataEntity())
                }
                listDB.toList()
            }
            .map {
                bookRepo.insertList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())

    }
}

