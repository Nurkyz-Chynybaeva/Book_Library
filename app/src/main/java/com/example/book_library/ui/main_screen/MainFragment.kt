package com.example.book_library.ui.main_screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.ui.MediatorBetweenFragments2
import com.example.book_library.ui.base.BaseFragment
import com.example.book_library.ui.book_screen.BookFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments2
    private lateinit var adapter: BooksAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBooks()
        subscribeToLiveData()
        setUpViews()
        setUpSearchView()
    }

    private fun setUpViews(){
        val recycler = binding.recycler
        adapter = BooksAdapter {
            listener.openFragment2(BookFragment.newInstance(id))
        }

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getAllBooks()
        }
    }

    private fun setUpSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (adapter.list.contains(query)){
                    adapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }
        })
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
