package com.example.book_library.domain.use_cases

import com.example.book_library.data.models.BookEntity
import com.example.book_library.data.repo.BookRepo
import com.example.book_library.domain.models.toBookEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GetBookByIdUseCase @Inject constructor(
    private val repo: BookRepo,
) {

    operator fun invoke(id: String): Single<BookEntity> {
        return repo.getBook(id)
            .subscribeOn(Schedulers.io())
            .map {
                it.toBookEntity()
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}