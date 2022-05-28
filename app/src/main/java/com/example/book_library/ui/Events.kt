package com.example.book_library.ui

import androidx.annotation.StringRes
import com.example.book_library.data.models.BookEntity

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    class FetchedBook(val bookE: BookEntity): Event()
}