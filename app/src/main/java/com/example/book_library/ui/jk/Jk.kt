package com.example.book_library.ui.jk

import android.os.Bundle
import android.view.View
import com.example.book_library.databinding.FragmentJkBinding
import com.example.book_library.ui.base.BaseFragment

class Jk: BaseFragment<JkViewModel, FragmentJkBinding>(
    JkViewModel::class.java,
    {
        FragmentJkBinding.inflate(it)
    }
) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}