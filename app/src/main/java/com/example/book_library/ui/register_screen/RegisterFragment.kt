package com.example.book_library.ui.register_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.book_library.R
import com.example.book_library.databinding.FragmentRegisterBinding
import com.example.book_library.ui.MediatorBetweenFragments
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>(
    RegisterViewModel::class.java,
    {
        FragmentRegisterBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogRegister.setOnClickListener {
          onBackPressed()
        }
    }

     private fun onBackPressed() {
         super.requireActivity().onBackPressed()
         activity?.overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
    }


    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }
}