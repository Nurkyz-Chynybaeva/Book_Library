package com.example.book_library.ui.main_screen

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book_library.R
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
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MediatorBetweenFragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBooks()
        subscribeToLiveData()
        setUpViews()
        navigationDrawerFeatures()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    private fun setUpViews(){
        val recycler = binding.recycler
        adapter = BooksAdapter {
            listener.openFragment(BookFragment.newInstance(it.objectId))
        }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getAllBooks()
        }
        binding.editToSearch.addTextChangedListener {
            it?.let {
                adapter.filter(it.toString())
            }
        }
    }

    private fun navigationDrawerFeatures() {
        with(binding) {
            toggle = ActionBarDrawerToggle(requireActivity(),
            drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> {
//                       openFragment2(MainFragment())
                    }
                    R.id.item2 -> {
//                        listener.openFragment()
                    }
                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
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
