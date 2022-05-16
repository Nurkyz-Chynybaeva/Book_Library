package com.example.book_library.ui.main_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book_library.R
import com.example.book_library.data.models.BookEntity

class BooksAdapter(private val click: (book: BookEntity) -> Unit) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private var list = listOf<BookEntity>()

    fun setData(list: List<BookEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View, private val click: (book: BookEntity) -> Unit) :
        RecyclerView.ViewHolder(view) {

        fun bind(book: BookEntity) {
            val text = itemView.findViewById<AppCompatTextView>(R.id.titleItem)
            text.text = book.name
            val img = itemView.findViewById<AppCompatImageView>(R.id.imgItem)
            Glide.with(itemView.context)
                .load(book.image)
                .into(img)

            itemView.setOnClickListener {
                click.invoke(book)
            }
        }
    }
}