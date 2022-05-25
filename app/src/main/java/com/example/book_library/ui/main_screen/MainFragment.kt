package com.example.book_library.ui.main_screen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.ui.MediatorBetweenFragments
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
    private lateinit var listener: MediatorBetweenFragments
    private lateinit var adapter: BooksAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBooks()
        subscribeToLiveData()
        setUpViews()
//        setUpSearchView()
    }

    private fun setUpViews(){
        val recycler = binding.recycler
        adapter = BooksAdapter {
            listener.openFragment(BookFragment.newInstance(it.objectId))
        }

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getAllBooks()
        }
    }

//    private fun setUpSearchView(){
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                binding.searchView.clearFocus()
//                if (adapter.list.contains(query)){
//                    if (query != null) {
//                        adapter.filter(query)
//                    }
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(query: String?): Boolean {
//                if (query != null) {
//                    adapter.filter(query)
//                }
//                return false
//            }
//        })
//    }



// ВОРОЙ ВАРИАНТ
//    private fun setUpSearchView(){
//        binding.editToSearch.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//        })
//    }

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
