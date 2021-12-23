package com.example.movieappservinformacion.interfaces

import androidx.room.*
import com.example.movieappservinformacion.entitys.MovieEntity
import com.example.movieappservinformacion.models.Movie

@Dao
interface MovieDao {
    @get:Query("SELECT * FROM Movie")
    @get:Transaction
    val movie: List<Movie?>?

    @Insert
    fun insert(movieEntity: MovieEntity?)

    @Update
    fun updateMoviebyId(movieEntity: MovieEntity?)

    @Delete
    fun deleteCourseByID(movieEntity: MovieEntity?)
}