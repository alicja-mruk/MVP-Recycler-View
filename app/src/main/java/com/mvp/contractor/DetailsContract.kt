package com.mvp.contractor

import android.content.Context
import android.os.Bundle
import com.mvp.view.OnlyForAdults

interface DetailsContract {

    interface View{

        fun initView()
        fun showToast(message : String)
        fun updateView()
        fun getContext() : Context
    }

    interface Presenter : OnlyForAdults {
        fun loadDataIntoView()
        fun dropView()
    }

}