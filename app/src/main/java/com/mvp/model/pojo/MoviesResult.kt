package com.mvp.model.pojo

import com.google.gson.annotations.SerializedName
import com.mvp.model.pojo.Movie

data class MoviesResult(
  val page: Int,
  val total_pages: Int,
  val total_results: Int,
  val results: List<Movie>
)