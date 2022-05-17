package com.example.book_library.ui.main_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book_library.R
import com.example.book_library.data.models.BookEntity
import com.example.book_library.databinding.ItemRecyclerBinding

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
        val binding = ItemRecyclerBinding.bind(view)
        return ViewHolder(click, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        private val click: (book: BookEntity) -> Unit,
        private val binding: ItemRecyclerBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookEntity) {
            with(binding){
                titleItem.text = book.name

                Glide.with(itemView.context)
                .load(book.image)
                .into(imgItem)
            }

            itemView.setOnClickListener {
                click.invoke(book)
            }
        }
    }
}