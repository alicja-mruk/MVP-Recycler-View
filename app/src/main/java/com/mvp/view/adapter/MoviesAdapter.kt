package com.mvp.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mvp.model.Movie
import kotlinx.android.synthetic.main.item_movie_model.view.*


class MoviesAdapter (private val list: List<Movie>,
                     private val listener: ItemClickListener): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

        itemClickListener = listener
        holder.itemView.setOnClickListener{view->
            itemClickListener?.clickRow(position)
        }

    }


    companion object{
        const val TAG = "MoviesAdapter"
        var itemClickListener :ItemClickListener? = null
    }

}
