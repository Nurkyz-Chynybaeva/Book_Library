package com.example.book_library.ui.welcome_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.book_library.ui.base.BaseViewModel
import javax.inject.Inject

//import io.reactivex.disposables.CompositeDisposable
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class WelcomeViewModel @Inject constructor(
): BaseViewModel() {
//    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
}