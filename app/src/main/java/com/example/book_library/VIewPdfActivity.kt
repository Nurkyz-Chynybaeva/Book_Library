package com.example.book_library

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.book_library.databinding.ActivityMainBinding
import com.example.book_library.databinding.ActivityViewPdfBinding

class VIewPdfActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPdfBinding
    val PDF_SELECTION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPdfBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        selectPdfFromStorage()
    }

    private fun selectPdfFromStorage() {
        val browserStorage = Intent(Intent.ACTION_GET_CONTENT)
        browserStorage.type = "application/pdf"
        browserStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browserStorage, "Select Pdf"),
            PDF_SELECTION_CODE)
    }

    fun showPdfFromUri(uri: Uri?) {
        binding.pdfView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PDF_SELECTION_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectPdf = data.data
            showPdfFromUri(selectPdf)
        }
    }


}