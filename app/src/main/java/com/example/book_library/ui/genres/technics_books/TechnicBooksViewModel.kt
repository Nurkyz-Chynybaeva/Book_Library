package com.example.book_library.ui.genres.technics_books

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.book_library.data.models.BookEntity
import com.example.book_library.domain.use_cases.GetBookAsLiveDataUseCase
import com.example.book_library.domain.use_cases.GetTechnicBooksUseCase
import com.example.book_library.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class TechnicBooksViewModel @Inject constructor(
    private val getTechnicBooksUseCase: GetTechnicBooksUseCase,
    private val getBookAsLiveDataUseCase: GetBookAsLiveDataUseCase,
) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val booksLiveData: LiveData<List<BookEntity>> = getBookAsLiveDataUseCase()

    init {
        getTechnicBooks()
    }

    fun getTechnicBooks() {
        compositeDisposable.add(
            getTechnicBooksUseCase()
                .subscribe({
                    Log.d("TAG", "technic books")
                }, {
                    Log.d("TAG", it.message ?: "error")
                })
        )
    }

}