package com.mvp.contractor

import com.mvp.model.Movie


interface MoviesListContract {

    interface View{
        fun initView()
        fun showOrHideRecyclerView(flag : Boolean)
        fun showProgressBar()
        fun hideProgressBar()
        fun showMovieList(movies : List<Movie>)
        fun showLoadingError(errorMessage: String)
    }

    interface Presenter{
        fun loadMovieList()
        fun dropView()
    }

    interface OnResponseCallback{
        fun onResponse(movies: List<Movie>)
        fun onError(errorMessage : String)
    }
}