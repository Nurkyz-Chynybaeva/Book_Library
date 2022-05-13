package com.example.book_library.ui.main_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.lifecycle.Observer
import com.example.book_library.data.models.UserDto
import com.example.book_library.databinding.FragmentMainBinding
import com.example.book_library.ui.Event
import com.example.book_library.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import es.voghdev.pdfviewpager.library.RemotePDFViewPager
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter
import es.voghdev.pdfviewpager.library.remote.DownloadFile
import java.lang.Exception

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    MainViewModel::class.java,
    {
        FragmentMainBinding.inflate(it)
    }
), DownloadFile.Listener {


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

    private lateinit var pdfViewPager: RemotePDFViewPager

    private fun fillViews(it: List<UserDto>) {


        pdfViewPager = RemotePDFViewPager(requireContext(),it[0].book,this)
        with(binding) {

//            binding.pdfView.fromUri(Uri.parse(it[0].book)).load()
            /*it.forEach {
                txtMain.text = it.name

                Glide.with(requireContext())
                    .load(it.image)
                    .into(binding.imgMain)

                btnMain.setOnClickListener {
                    val intent = Intent(requireContext(), VIewPdfActivity::class.java)
                    startActivity(intent)
                }

                binding.pdfView.fromAsset(it.book).load()
//                binding.pdfView.fromAsset("магия_утра.pdf").load()
            }*/
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onSuccess(url: String?, destinationPath: String?) {

        val adapter = PDFPagerAdapter(requireContext(),destinationPath)
        pdfViewPager.adapter = adapter
        binding.flContainer.addView(pdfViewPager,  )

        Toast.makeText(requireContext(), "SUCCESS",Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(e: Exception?) {
        Toast.makeText(requireContext(), "FAIL",Toast.LENGTH_SHORT).show()

    }

    override fun onProgressUpdate(progress: Int, total: Int) {

    }
}


