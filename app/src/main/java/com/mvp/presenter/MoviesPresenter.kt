package com.mvp.presenter

import com.mvp.contractor.MoviesListContract
import com.mvp.model.Movie
import com.mvp.model.repository.MovieRepository
import com.mvp.model.repository.SimulateMovieClient

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

    override fun loadMovieList() {
        view?.showProgressBar()
        client.getMovieList(callback)

    }

    private var callback = object : MoviesListContract.OnResponseCallback {
        override fun onResponse(movies: List<Movie>) {
            view?.showMovieList(movies)
            view?.hideProgressBar()
        }

        override fun onError(errorMessage: String) {
            view?.hideProgressBar()
            view?.showLoadingError(errorMessage)
        }

    }

}