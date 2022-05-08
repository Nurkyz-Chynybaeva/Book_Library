package com.example.book_library.ui

import androidx.fragment.app.Fragment

interface MediatorBetweenFragments {
       fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true)
}