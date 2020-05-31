package com.mvp.contractor

import android.content.Context
import com.mvp.model.pojo.Movie
import com.mvp.util.MovieData
import com.mvp.util.OnlyForAdults

interface DetailsContract {

    interface View : MovieData {

        fun initView()
        fun showToast(message : String)
        fun updateView()
        fun getContext() : Context
    }

    interface Presenter : OnlyForAdults {
        fun loadDataIntoView()
        fun getMovieData() : Movie?
        fun dropView()
    }

}