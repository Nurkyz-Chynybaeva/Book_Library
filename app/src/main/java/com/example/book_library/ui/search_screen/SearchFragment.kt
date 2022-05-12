package com.example.book_library.ui.search_screen

import android.os.Bundle
import com.example.book_library.databinding.FragmentSearchBinding
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>(
    SearchViewModel::class.java,
    {
        FragmentSearchBinding.inflate(it)
    }
) {

    companion object {
        @JvmStatic
        fun newInstance()=
            SearchFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}