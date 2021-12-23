package com.example.movieappservinformacion.services

import com.example.movieappservinformacion.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @get:GET("movie/popular?api_key=09963e300150f9831c46a1828a82a984&language=en-US")
    val movies: Call<MovieResponse?>?
}