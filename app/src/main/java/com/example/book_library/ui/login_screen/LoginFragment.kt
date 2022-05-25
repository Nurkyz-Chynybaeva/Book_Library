package com.example.book_library.ui.login_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.book_library.R
import com.example.book_library.databinding.FragmentLoginBinding
import com.example.book_library.ui.MainActivity
import com.example.book_library.ui.MediatorBetweenFragments
import com.example.book_library.ui.base.BaseFragment
import com.example.book_library.ui.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    LoginViewModel::class.java,
    {
        FragmentLoginBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            listener.openFragment(MainFragment())
        }
    }

}