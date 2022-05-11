package com.example.book_library.ui.main_screen

import android.os.Bundle
import android.view.View
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.di.NetworkModule
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUsers()
    }


    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}

