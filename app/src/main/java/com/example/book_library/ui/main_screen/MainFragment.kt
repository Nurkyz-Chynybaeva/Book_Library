package com.example.book_library.ui.main_screen

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
) {

    private lateinit var adapter: BooksAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBooks()
        subscribeToLiveData()

        val recycler = binding.recycler
        adapter = BooksAdapter {

        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getAllBooks()
        }
    }

    private fun subscribeToLiveData() {
        viewModel.booksLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}

