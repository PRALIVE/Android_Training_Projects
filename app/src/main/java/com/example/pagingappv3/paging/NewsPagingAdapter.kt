package com.example.pagingappv3.paging

import android.app.ProgressDialog.show
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingappv3.R
import com.example.pagingappv3.models.Article
import com.example.pagingappv3.savedroomdatabase.SavedDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsPagingAdapter(val saveddao: SavedDao) :
    PagingDataAdapter<Article, NewsPagingAdapter.Newsviewholder>(COMPARATOR) {

    inner class Newsviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val author = itemView.findViewById<TextView>(R.id.author)
        val date = itemView.findViewById<TextView>(R.id.date)
        val btn = itemView.findViewById<Button>(R.id.button)
    }

    override fun onBindViewHolder(holder: Newsviewholder, position: Int) {
        val curr = getItem(position)
        if (curr != null) {
            holder.author.text = curr.author
            holder.title.text = curr.title
            holder.date.text = curr.publishedAt
            holder.btn.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch { saveddao.insertArticles(curr)
               withContext(Dispatchers.Main) { Toast.makeText(holder.author.context, "Data Added "+curr.primaryKey, Toast.LENGTH_SHORT).show() }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Newsviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return Newsviewholder(view)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.source?.id == newItem.source?.id
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

        }
    }
}