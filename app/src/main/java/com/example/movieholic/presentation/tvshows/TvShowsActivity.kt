package com.example.movieholic.presentation.tvshows

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
import com.example.movieholic.databinding.ActivityTvShowsBinding
import com.example.movieholic.presentation.dagger.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowsViewModelFactory
    private lateinit var binding: ActivityTvShowsBinding
    private lateinit var tvShowsViewModel: TvShowsViewModel
    private lateinit var tvShowsAdapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowsViewModel = ViewModelProvider(this, factory).get(TvShowsViewModel::class.java)
        initRecyclerView()
        displayPopularTvShows()
    }

    private fun initRecyclerView(){
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowsAdapter = TvShowAdapter()
        binding.tvRecyclerView.adapter = tvShowsAdapter
    }

    private fun displayPopularTvShows(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowsViewModel.getTvShows()
        responseLiveData.observe(this) {
            if (it != null) {
                tvShowsAdapter.setTvList(it)
                tvShowsAdapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
                binding.tvProgressBar.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.updateButton -> {
                updateTvShows()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun updateTvShows(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowsViewModel.updateTvShows()
        responseLiveData.observe(this) {
            if (it != null) {
                tvShowsAdapter.setTvList(it)
                tvShowsAdapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No new updates", Toast.LENGTH_LONG).show()
                binding.tvProgressBar.visibility = View.GONE
            }
        }
    }
}