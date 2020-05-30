package com.mvp.contractor

import android.content.Context
import com.mvp.model.pojo.Movie


interface MoviesListContract {

    interface View{
        fun initView()
        fun getContext() : Context
        fun showOrHideRecyclerView(flag : Boolean)
        fun showProgressBar()
        fun hideProgressBar()
        fun showMovieList(movies : List<Movie>)
        fun showLoadingError(errorMessage: String?)
        fun showToast(message : String)
    }

    interface Presenter {
        fun loadMovieList()
        fun dropView()
        fun openDetailsActivity(movie : Movie)
    }

    interface OnResponseCallback{
        fun onResponse(movies: List<Movie>)
        fun onError(errorMessage : String?)
    }

}