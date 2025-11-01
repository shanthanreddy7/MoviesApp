package com.example.moviesapp.data.model

data class MovieResponse(
    val Search: List<Movie>? = null,
    val totalResults: String? = null,
    val Response: String? = null,
    val Error: String? = null
)
