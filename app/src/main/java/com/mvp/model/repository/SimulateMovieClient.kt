package com.mvp.model.repository

import com.mvp.contractor.MoviesListContract
import com.mvp.model.Movie
import com.mvp.model.Type
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SimulateMovieClient : MovieRepository {
    //get data from network/api
    override fun getMovieList(onResponseCallback: MoviesListContract.OnResponseCallback) {
        val movies: ArrayList<Movie> = ArrayList()

        try {
            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "IT", "23-06-2015",
                    7.6, 127, Type.THRILLER
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE),
                    "Glass Trap", "19-03-2013",
                    9.9, 199, Type.ACTION
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Killer", "13-03-2000",
                    4.3, 133, Type.HORROR
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Deadpool", "23-06-2015",
                    6.7, 333, Type.ACTION
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "IT", "23-06-2015",
                    7.6, 127, Type.THRILLER
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE),
                    "Glass Trap", "19-03-2013",
                    9.9, 199, Type.ACTION
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Killer", "13-03-2000",
                    4.3, 133, Type.HORROR
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Deadpool", "23-06-2015",
                    6.7, 333, Type.ACTION
                )
            );
            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "IT", "23-06-2015",
                    7.6, 127, Type.THRILLER
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE),
                    "Glass Trap", "19-03-2013",
                    9.9, 199, Type.ACTION
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Killer", "13-03-2000",
                    4.3, 133, Type.HORROR
                )
            )

            movies.add(
                Movie(
                    RANDOM.nextInt(Integer.MAX_VALUE), "Deadpool", "23-06-2015",
                    6.7, 333, Type.ACTION
                )
            )


            onResponseCallback.onResponse(movies)

        } catch (e: ParseException) {
            onResponseCallback.onError("Error while parsing data has ocurred")
        }
    }

    companion object {
        val RANDOM = Random()
    }
}