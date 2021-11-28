package com.cursokotlin.movieapp.repository

import com.cursokotlin.movieapp.data.model.MovieList

interface MovieRepository {
    //suspend es para usar coroutines que es como esperar a que termine de recibir data para finalizar
    suspend fun getUpcomingMovies():MovieList
    suspend fun getTopRatedMovies():MovieList
    suspend fun getPopularMovies():MovieList
}