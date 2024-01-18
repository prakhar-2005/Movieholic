package com.example.movieholic.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movieholic.R
import com.example.movieholic.databinding.ActivityMainBinding
import com.example.movieholic.presentation.artists.ArtistsActivity
import com.example.movieholic.presentation.movies.MoviesActivity
import com.example.movieholic.presentation.tvshows.TvShowsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.movieButton.setOnClickListener {
            startActivity(Intent(this, MoviesActivity::class.java))
        }

        binding.tvSeriesButton.setOnClickListener {
            startActivity(Intent(this, TvShowsActivity::class.java))
        }

        binding.peopleButton.setOnClickListener {
            startActivity(Intent(this, ArtistsActivity::class.java))
        }
    }
}