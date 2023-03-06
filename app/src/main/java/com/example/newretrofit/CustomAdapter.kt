package com.example.newretrofit

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val userList : List<Articles>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val texttitle = itemView.findViewById(R.id.texttitle) as TextView
        val textauthor = itemView.findViewById(R.id.textauthor) as TextView
        //val textcontent = itemView.findViewById(R.id.textcontent) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user:Articles = userList[position]

        holder.textauthor.text = user.author
        holder.texttitle.text = user.title
        //holder.textcontent.text = user.content
    }
}