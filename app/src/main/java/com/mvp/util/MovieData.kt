package com.mvp.util

import com.mvp.model.pojo.Movie

interface MovieData {
    fun getMovieDataFromActivity() : Movie?
}