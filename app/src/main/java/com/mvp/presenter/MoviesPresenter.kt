package com.mvp.presenter

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.mvp.contractor.MoviesListContract
import com.mvp.model.network.connection.NetworkStatusImpl
import com.mvp.model.pojo.Movie
import com.mvp.model.repository.MovieRepository
import com.mvp.view.DetailsActivity

class MoviesPresenter(
    _view: MoviesListContract.View?,
    _client: MovieRepository
) : MoviesListContract.Presenter {
    private var view: MoviesListContract.View? = _view
    private var client: MovieRepository = _client

    init {
        view?.initView()
    }

    override fun dropView() {
        view = null
    }

    override fun openDetailsActivity(movie:Movie) {
        val intent = Intent(view?.getContext(), DetailsActivity::class.java ).apply {
            putExtra(MOVIE_KEY, movie)
        }
        view?.getContext()?.startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun loadMovieList() {
        val networkStatus = NetworkStatusImpl(view!!.getContext())
        if(networkStatus.isOnline()) {
            view?.showProgressBar()
            client.getMovieList(callback)
        }else{
            view?.hideProgressBar()
            view?.showToast(NO_NETWORK_CONNECTION)
        }
    }


    private var callback = object : MoviesListContract.OnResponseCallback {
        override fun onResponse(movies: List<Movie>) {
            view?.showMovieList(movies)
            view?.hideProgressBar()
        }

        override fun onError(errorMessage: String?) {
            view?.hideProgressBar()
            view?.showLoadingError(errorMessage)
        }
    }

    companion object{
        const val NO_NETWORK_CONNECTION = "No network connection"
        const val MOVIE_KEY = "movie"
    }

}