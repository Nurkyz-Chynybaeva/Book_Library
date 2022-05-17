package com.example.book_library.ui.book_screen

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.book_library.data.models.BookEntity
import com.example.book_library.databinding.FragmentBookBinding
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookFragment : BaseFragment<BookViewModel, FragmentBookBinding>(
    BookViewModel::class.java,
    {
        FragmentBookBinding.inflate(it)
    }
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setId(arguments?.getInt(KEY_ID))
        viewModel.fetchBook()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner) {
            when (it) {
                is Event.FetchedBook -> setupViews(it.bookE)
            }
        }
    }

    private fun setupViews(bookE: BookEntity) {
        with(binding) {
            Glide.with(requireContext()).load(bookE.image).into(img)
            name.text = bookE.name
        }
    }


    companion object {
        const val KEY_ID = "key_id"
        fun newInstance(id: Int): BookFragment {
            val args = Bundle().apply { putInt(KEY_ID, id) }
            return BookFragment().apply { arguments = args }
        }
    }
}