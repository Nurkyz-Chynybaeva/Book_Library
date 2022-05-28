package com.example.book_library.ui.book_screen

import android.os.Bundle
import android.view.View
import com.example.book_library.data.models.BookEntity
import com.example.book_library.databinding.FragmentBookBinding
import com.example.book_library.extensions.showToast
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import es.voghdev.pdfviewpager.library.RemotePDFViewPager
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter
import es.voghdev.pdfviewpager.library.remote.DownloadFile

@AndroidEntryPoint
class BookFragment : BaseFragment<BookViewModel, FragmentBookBinding>(
    BookViewModel::class.java,
    {
        FragmentBookBinding.inflate(it)
    }
) , DownloadFile.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(KEY_ID)?.let { viewModel.setId(it) }
        viewModel.fetchBook()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
        onProgress()
    }


    private fun subscribeToLiveData() {
        viewModel.event.observe(viewLifecycleOwner) {
            when (it) {
                is Event.FetchedBook -> fillBook(it.bookE)
                is Event.ShowToast -> showToast(getString(it.resId))
            }

        }
    }

    private lateinit var pdfViewPager: RemotePDFViewPager

    private fun fillBook(it: BookEntity) {
        pdfViewPager = RemotePDFViewPager(requireContext(), it.book, this)
    }

    override fun onSuccess(url: String?, destinationPath: String?) {

        val adapter = PDFPagerAdapter(requireContext(), destinationPath)
        pdfViewPager.adapter = adapter
        binding.flContainer.addView(pdfViewPager)
    }

    override fun onFailure(e: Exception?){ showToast("Sorry there was an error") }

    private fun onProgress(){
        var progressStatus = 0
            Thread(Runnable {
                while (progressStatus < 100){
                    progressStatus +=1
                    Thread.sleep(100)
                    binding.progressBar.progress = progressStatus
                }
            }).start()
    }

    override fun onProgressUpdate(progress: Int, total: Int) {}

    companion object {
        const val KEY_ID = "key_id"
        fun newInstance(id: String): BookFragment {
            val args = Bundle().apply { putString(KEY_ID, id) }
            return BookFragment().apply { arguments = args }
        }
    }
}