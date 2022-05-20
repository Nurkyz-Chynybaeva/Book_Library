package com.example.book_library.ui.book_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.book_library.data.models.BookDto
import com.example.book_library.databinding.FragmentBookBinding
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import es.voghdev.pdfviewpager.library.RemotePDFViewPager
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter
import es.voghdev.pdfviewpager.library.remote.DownloadFile
import java.lang.Exception

@AndroidEntryPoint
class BookFragment : BaseFragment<BookViewModel, FragmentBookBinding>(
    BookViewModel::class.java,
    {
        FragmentBookBinding.inflate(it)
    }
) , DownloadFile.Listener {

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
                is Event.FetchedBook -> fillBook(it.bookE)
            }
        }
    }

    private lateinit var pdfViewPager: RemotePDFViewPager

    private fun fillBook(it: List<BookDto>) {
        pdfViewPager = RemotePDFViewPager(requireContext(),it[0].book,this)
    }

    override fun onSuccess(url: String?, destinationPath: String?) {

        val adapter = PDFPagerAdapter(requireContext(),destinationPath)
        pdfViewPager.adapter = adapter
        binding.flContainer.addView(pdfViewPager)

        Toast.makeText(requireContext(), "SUCCESS", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(e: Exception?) {
        Toast.makeText(requireContext(), "FAIL", Toast.LENGTH_SHORT).show()

    }

    override fun onProgressUpdate(progress: Int, total: Int) {

    }

    companion object {
        const val KEY_ID = "key_id"
        fun newInstance(id: Int): BookFragment {
            val args = Bundle().apply { putInt(KEY_ID, id) }
            return BookFragment().apply { arguments = args }
        }
    }
}