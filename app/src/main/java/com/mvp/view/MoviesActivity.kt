package com.mvp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mvprecyclerview.R
import com.mvp.contractor.MoviesListContract
import com.mvp.model.pojo.Movie
import com.mvp.model.repository.SimulateMovieClient
import com.mvp.presenter.MoviesPresenter
import com.mvp.util.adapter.ItemClickListener
import com.mvp.util.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity(), MoviesListContract.View {
    private  var presenter : MoviesListContract.Presenter ? = null
    private var adapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        presenter = MoviesPresenter(this, SimulateMovieClient())

        initView()
    }

    override fun initView() {

        swipeLayout.setOnRefreshListener(listener)

        swipeLayout.setColorSchemeColors(

            ContextCompat.getColor(this, R.color.colorPrimary),
            ContextCompat.getColor(this, R.color.colorAccent),
            ContextCompat.getColor(this, android.R.color.holo_green_light)

        )
    }

    override fun getContext(): Context {
        return this
    }

    private val listener  = SwipeRefreshLayout.OnRefreshListener { presenter?.loadMovieList() }

    override fun showProgressBar() {
        swipeLayout.isRefreshing = true
    }

    override fun hideProgressBar() {
        swipeLayout.isRefreshing = false
    }

    override fun showOrHideRecyclerView(flag: Boolean) {
       if(flag){
           no_message.visibility = View.GONE
           movies_recyclerView.visibility = View.VISIBLE
       }else{
           no_message.visibility = View.VISIBLE
           movies_recyclerView.visibility = View.GONE
       }
    }

    override fun showMovieList(movies: List<Movie>) {
        movies_recyclerView.adapter = adapter
        if(movies.isNotEmpty()) {

            showOrHideRecyclerView(true)
            movies_recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = MoviesAdapter(movies, object : ItemClickListener {
                    override fun clickRow(position: Int) {
                       //TODO do some action while click performed
                        val item = movies[position]
                        presenter?.openDetailsActivity(item)
                    }

                })
            }
        }
    }

    override fun showLoadingError(errorMessage: String?) {
        if (errorMessage != null) {
            hideProgressBarAndShowError(errorMessage)
        }
        showOrHideRecyclerView(false)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideProgressBarAndShowError(message: String) {
        no_message.visibility = View.VISIBLE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        showOrHideRecyclerView(false)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.dropView()
    }

}
