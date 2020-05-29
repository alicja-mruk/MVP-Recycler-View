package com.mvp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvp.model.pojo.Movie


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
