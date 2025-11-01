package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.moviesapp.ui.screens.MovieListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Call your Compose screen
            MovieListScreen(apiKey = "YOUR_OMDB_API_KEY")
        }
    }
}
