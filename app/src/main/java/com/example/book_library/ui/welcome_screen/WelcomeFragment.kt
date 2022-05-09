package com.example.book_library.ui.welcome_screen

import android.os.Bundle
import android.view.View
import com.example.book_library.databinding.FragmentWelcomeBinding
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment: BaseFragment<WelcomeViewModel, FragmentWelcomeBinding>(
    WelcomeViewModel::class.java,
    {
        FragmentWelcomeBinding.inflate(it)
    }
) {

}