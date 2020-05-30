package com.mvp.model.repository



import com.mvp.contractor.MoviesListContract
import com.mvp.model.network.connection.NetworkStatus
import com.mvp.model.network.connection.NetworkStatusImpl
import com.mvp.model.pojo.MoviesResult
import com.mvp.model.network.request.MovieApiService
import com.mvp.model.network.request.ServiceBuilder
import dagger.Module
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimulateMovieClient : MovieRepository {
    //get data from network/api

    override fun getMovieList(onResponseCallback: MoviesListContract.OnResponseCallback) {
        val request  = ServiceBuilder.buildService(
            MovieApiService::class.java)
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