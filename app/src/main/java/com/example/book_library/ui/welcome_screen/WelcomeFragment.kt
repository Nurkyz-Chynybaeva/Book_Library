package com.example.book_library.ui.welcome_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.book_library.databinding.FragmentWelcomeBinding
import com.example.book_library.ui.MediatorBetweenFragments
import com.example.book_library.ui.base.BaseFragment
import com.example.book_library.ui.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<WelcomeViewModel, FragmentWelcomeBinding>(
    WelcomeViewModel::class.java,
    {
        FragmentWelcomeBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnWelcome.setOnClickListener {
            listener.openFragment(MainFragment.newInstance())
        }
    }
}