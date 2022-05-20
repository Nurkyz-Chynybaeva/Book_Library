package com.example.book_library.ui.book_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.book_library.domain.use_cases.GetBookByIdUseCase
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBookByIdUseCase: GetBookByIdUseCase,
) : BaseViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    private var id: Int = 1
    fun setId(id: Int?) {
        this.id = id ?: 1
    }

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event


    fun fetchBook() {
        compositeDisposable.add(
            getBookByIdUseCase(id)
                .subscribe({
                    Log.d("tag", "tag")
                }, {
                    Log.d("tag", "error")
                })
        )

    }

}