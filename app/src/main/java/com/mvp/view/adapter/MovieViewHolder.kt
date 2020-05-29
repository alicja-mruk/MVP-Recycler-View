package com.mvp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvprecyclerview.R
import com.mvp.model.pojo.Movie

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie_model, parent, false)) {
    private var title: TextView? = null
    private var releaseDate: TextView? = null
    private var forAdult: TextView? = null
    private var posterPath: ImageView? = null
    private var voteAverage: TextView? = null
    private var voteCount: TextView? = null

    init {
        title = itemView.findViewById(R.id.title)
        releaseDate = itemView.findViewById(R.id.date)
        voteAverage = itemView.findViewById(R.id.rating)
    }

    fun bind(movie: Movie) {
        title?.text = movie.title
        releaseDate?.text = movie.release_date
        voteAverage?.text = movie.vote_average.toString()
    }

}