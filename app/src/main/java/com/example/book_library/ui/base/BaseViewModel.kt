package com.example.book_library.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {

    protected val disposable by lazy {
        CompositeDisposable()
    }


    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}