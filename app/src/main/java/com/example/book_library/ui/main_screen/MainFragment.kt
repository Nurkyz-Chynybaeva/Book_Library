package com.example.book_library.ui.main_screen

import android.os.Bundle
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
) {
    companion object{
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
