package com.example.book_library.ui.main_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.book_library.VIewPdfActivity
import com.example.book_library.data.models.UserDto
import com.example.book_library.data.models.UserEntity
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.di.NetworkModule
import com.example.book_library.domain.use_cases.GetUserUseCase
import com.example.book_library.ui.Event
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
        subscribeToLiveData()

    }

    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Event.FetchedUser -> fillViews(it.user)
            }
        }
        )
    }

    private fun fillViews(it: List<UserDto>) {
        with(binding) {
            it.forEach {
                txtMain.text = it.name

                Glide.with(requireContext())
                    .load(it.image)
                    .into(binding.imgMain)

                btnMain.setOnClickListener {
                    val intent = Intent(requireContext(), VIewPdfActivity::class.java)
                    startActivity(intent)
                }

                binding.pdfView.fromAsset(it.book).load()
            }
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}

