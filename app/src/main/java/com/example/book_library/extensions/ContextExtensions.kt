package com.example.book_library.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, length: Int? = Toast.LENGTH_SHORT){
    Toast.makeText(requireContext(),message, length!!).show()
}