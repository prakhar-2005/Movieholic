package com.example.movieholic.presentation.artists

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
import com.example.movieholic.databinding.ActivityArtistsBinding
import com.example.movieholic.presentation.dagger.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var binding: ActivityArtistsBinding
    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var artistsAdapter: ArtistsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistsViewModel = ViewModelProvider(this, factory).get(ArtistsViewModel::class.java)
        initRecyclerView()
        displayPopularArtists()
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistsAdapter = ArtistsAdapter()
        binding.artistRecyclerView.adapter = artistsAdapter
    }

    private fun displayPopularArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistsViewModel.getArtists()
        responseLiveData.observe(this) {
            if (it != null) {
                artistsAdapter.setArtistList(it)
                artistsAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
                binding.artistProgressBar.visibility = View.GONE
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
                updateArtists()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistsViewModel.updateArtists()
        responseLiveData.observe(this) {
            if (it != null) {
                artistsAdapter.setArtistList(it)
                artistsAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                Toast.makeText(applicationContext, "No new updates", Toast.LENGTH_LONG).show()
                binding.artistProgressBar.visibility = View.GONE
            }
        }
    }
}