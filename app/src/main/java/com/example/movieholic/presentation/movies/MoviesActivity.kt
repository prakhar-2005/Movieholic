package com.example.movieholic.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieholic.R
import com.example.movieholic.databinding.ActivityMoviesActivtiyBinding
import com.example.movieholic.presentation.dagger.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var binding: ActivityMoviesActivtiyBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var moviesAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies_activtiy)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        initRecyclerView()
        displayPopularMovies()
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesAdapter = MoviesAdapter()
        binding.movieRecyclerView.adapter = moviesAdapter
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                moviesAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
                binding.movieProgressBar.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.updateButton -> {
                updateMovies()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovies()
        responseLiveData.observe(this) {
            if (it != null) {
                moviesAdapter.setMovieList(it)
                moviesAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No new updates", Toast.LENGTH_LONG).show()
                binding.movieProgressBar.visibility = View.GONE
            }
        }
    }

}