package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("apikey") apiKey: String,
        @Query("s") query: String
    ): MovieResponse
}
