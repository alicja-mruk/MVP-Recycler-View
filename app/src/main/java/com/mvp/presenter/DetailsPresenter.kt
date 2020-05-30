package com.mvp.presenter


import com.mvp.contractor.DetailsContract
import com.mvp.view.OnlyForAdults


class DetailsPresenter(
    _view: DetailsContract.View?
) : DetailsContract.Presenter, OnlyForAdults{
    private var view :DetailsContract.View? = _view

    init {
        view?.initView()
    }

    override fun loadDataIntoView() {
        view?.updateView()
    }

    override fun dropView() {
        view = null
    }

    override fun onlyForAdults(adult: Boolean?): Boolean {
        return adult!!
    }
}