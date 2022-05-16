package com.example.book_library.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.book_library.data.models.BookEntity
import com.example.book_library.data.repo.BookRepo
import javax.inject.Inject

class GetBookAsLiveDataUseCase @Inject constructor(private val booksRepo: BookRepo) {
    operator fun invoke(): LiveData<List<BookEntity>> {
        return booksRepo.getBooksAsLiveData()
    }
}
