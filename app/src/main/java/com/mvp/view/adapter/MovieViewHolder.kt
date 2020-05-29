package com.mvp.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvprecyclerview.R
import com.mvp.model.Movie
import com.mvp.model.Type
import java.util.*

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie_model, parent, false)) {
    private var title: TextView? = null
    private var date: TextView? = null
    private var rating: TextView? = null

    init {
        title = itemView.findViewById(R.id.title)
        date = itemView.findViewById(R.id.date)
        rating = itemView.findViewById(R.id.rating)

    }

    fun bind(movie: Movie) {
        title?.text = movie.title
        date?.text = movie.releaseDate
        rating?.text = movie.rating.toString()
    }

}