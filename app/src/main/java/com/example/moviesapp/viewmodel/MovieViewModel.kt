package com.example.moviesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val movies = mutableStateListOf<Movie>()

    fun searchMovies(apiKey: String, query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchMovies("a264d628", query)

                movies.clear()

                if (response.Search != null)
                {
                    movies.addAll(response.Search)
                }

            } catch (e: Exception) {
                e.printStackTrace()
\            }
        }
    }
}
