package com.mvp.model

import java.util.*

data class Movie (
    var id:Int,
    var title : String,
    var releaseDate : String,
    var rating: Double,
    var durationInMinutes : Int,
    var type : Type
)

