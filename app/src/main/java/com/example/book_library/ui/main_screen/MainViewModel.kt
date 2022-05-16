package com.example.book_library.ui.main_screen

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.book_library.data.models.BookEntity
import com.example.book_library.domain.use_cases.GetBookAsLiveDataUseCase
import com.example.book_library.domain.use_cases.GetAllBooksUseCase
import com.example.book_library.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooksUseCase,
   private val getBookAsLiveDataUseCase: GetBookAsLiveDataUseCase,
) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val booksLiveData: LiveData<List<BookEntity>> = getBookAsLiveDataUseCase()

    init {
        getAllBooks()
    }

     fun getAllBooks() {
        compositeDisposable.add(
            getAllBooksUseCase()
                .subscribe({

                    Log.d("TAG", "get users")

                }, {
                    Log.d("TAG", "error")
                })
        )
    }

}