package com.example.book_library.ui.genres.technics_books

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_library.databinding.FragmentTechnicBooksBinding
import com.example.book_library.ui.MediatorBetweenFragments
import com.example.book_library.ui.MediatorBetweenFragments2
import com.example.book_library.ui.base.BaseFragment
import com.example.book_library.ui.book_screen.BookFragment
import com.example.book_library.ui.main_screen.BooksAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TechnicBooksFragment : BaseFragment<TechnicBooksViewModel, FragmentTechnicBooksBinding>(
    TechnicBooksViewModel::class.java,
    {
        FragmentTechnicBooksBinding.inflate(it)
    }
) {
    private lateinit var listener: MediatorBetweenFragments
    private lateinit var adapter: BooksAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTechnicBooks()
        subscribeToLiveData()
        setUpViews()
//        setUpSearchView()
    }

    private fun setUpViews(){
        val recycler = binding.recycler
        adapter = BooksAdapter {
            listener.openFragment(BookFragment.newInstance(id))
        }

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getTechnicBooks()
        }
    }

    private fun subscribeToLiveData() {
        viewModel.booksLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    companion object {
        fun newInstance(): TechnicBooksFragment {
            return TechnicBooksFragment()
        }
    }
}