package com.mvp.model.repository

import com.mvp.contractor.MoviesListContract

interface MovieRepository {
    fun getMovieList(onResponseCallback: MoviesListContract.OnResponseCallback)
}