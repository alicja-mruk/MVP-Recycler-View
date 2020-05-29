package com.mvp.model.repository


import android.util.Log
import androidx.core.content.res.TypedArrayUtils.getText
import com.example.mvprecyclerview.R
import com.mvp.contractor.MoviesListContract
import com.mvp.model.pojo.MoviesResult
import com.mvp.model.retrofit.MovieApiService
import com.mvp.model.retrofit.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SimulateMovieClient : MovieRepository {
    //get data from network/api

    override fun getMovieList(onResponseCallback: MoviesListContract.OnResponseCallback) {
        val request  = ServiceBuilder.buildService(MovieApiService::class.java)
        val call = request.getMovies(API_KEY)

            call.enqueue(object: Callback <MoviesResult> {
                override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
                    if (response.isSuccessful) {
                        onResponseCallback.onResponse(response.body()!!.results)
                    }
                }

                override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                    onResponseCallback.onError(t.message)
                }

            })
    }
    companion object{
        const val API_KEY = "d675c2ef9df8cd0dfde40c7290e54629"
    }

}