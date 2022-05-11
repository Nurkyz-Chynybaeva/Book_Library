package com.example.book_library.ui.user_screen

import android.os.Bundle
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.databinding.FragmentUserBinding
import com.example.book_library.ui.base.BaseFragment
import com.example.book_library.ui.main_screen.MainViewModel
import com.example.book_library.ui.search_screen.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>(
    UserViewModel::class.java,
    {
        FragmentUserBinding.inflate(it)
    }
) {


    companion object {
        @JvmStatic
        fun newInstance()=
            UserFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}