package com.example.book_library.ui

import androidx.annotation.StringRes
import com.example.book_library.data.models.BookDto

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    object ShowLoading: Event()
    object StopLoading: Event()
    class FetchedUser(val book: List<BookDto>): Event()
}