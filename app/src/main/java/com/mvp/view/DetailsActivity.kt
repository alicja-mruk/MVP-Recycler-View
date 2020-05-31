package com.mvp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mvprecyclerview.R
import com.mvp.contractor.DetailsContract
import com.mvp.model.pojo.Movie
import com.mvp.presenter.DetailsPresenter
import com.mvp.presenter.MoviesPresenter
import com.mvp.util.MovieData
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity (
): AppCompatActivity(), DetailsContract.View{

    private  var presenter : DetailsContract.Presenter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        presenter = DetailsPresenter(this)
        initView()
    }

    override fun initView() {
        actionBar?.hide()
        presenter?.loadDataIntoView()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun updateView() {
        val movie : Movie? = presenter?.getMovieData()
        if (movie != null) {
            if(presenter?.onlyForAdults()!!){
                for_adult_details.text = getString(R.string.no)
            }else {
                for_adult_details.text = getString(R.string.yes)
            }
        }
            title_details.text = movie?.title
            Glide.with(this)
                .load(IMG_PATH + movie?.poster_path)
                .placeholder(R.drawable.placeholder)
                .into(image_details)
            release_date_details.text = movie?.release_date
            popularity_details.text = movie?.vote_count.toString()
    }

    override fun getContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.dropView()
    }

    override fun getMovieDataFromActivity(): Movie? {
        return intent.getParcelableExtra(MoviesPresenter.MOVIE_KEY)
    }

    companion object{
        const val IMG_PATH = "https://image.tmdb.org/t/p/w300/"
    }

}
