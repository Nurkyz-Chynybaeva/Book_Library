package com.example.book_library.ui.main_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.book_library.domain.use_cases.GetUserUseCase
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _event = MutableLiveData<Event?>()
    val event: LiveData<Event?>
        get() = _event

    fun getUsers() {
        compositeDisposable.add(
            getUserUseCase()
                .subscribe({
                   _event.value = Event.FetchedUser(it)

                }, {
                    Log.d("TAG", "error")
                })
        )
    }

}