package com.mvp.presenter


import com.mvp.contractor.DetailsContract
import com.mvp.model.pojo.Movie
import com.mvp.util.OnlyForAdults


class DetailsPresenter(
    _view: DetailsContract.View?
) : DetailsContract.Presenter, OnlyForAdults {

    private var view :DetailsContract.View? = _view

    init {
        view?.initView()
    }

    override fun loadDataIntoView() {
        view?.updateView()
    }

    override fun getMovieData(): Movie? {
        return view?.getMovieDataFromActivity()
    }

    override fun dropView() {
        view = null
    }

    override fun onlyForAdults() : Boolean{
     return getMovieData()?.adult == true
    }
}