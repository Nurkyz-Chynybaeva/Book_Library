package com.example.book_library.ui.main_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.book_library.data.repo.UserRepo
import com.example.book_library.domain.models.User
import com.example.book_library.domain.use_cases.GetUserUseCase
import com.example.book_library.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _user = MutableLiveData<List<User>>()
    val user: LiveData<List<User>>
        get() = _user

    fun getUsers() {
        compositeDisposable.add(
            getUserUseCase()
                .subscribe({
                    Log.d("TAG", it.toString())
                }, {
                    Log.d("TAG", "error")
                })
        )
    }
}