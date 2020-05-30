package com.mvp.model.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResult(
  val page: Int,
  val total_pages: Int,
  val total_results: Int,
  val results: List<Movie>
) : Parcelable