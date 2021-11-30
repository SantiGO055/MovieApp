package com.cursokotlin.movieapp.repository

import com.cursokotlin.movieapp.data.model.MovieList

//con estas interfaces utilizo la utilizo para poder implementarla en cualquier lado
interface MovieRepository {
    //suspend es para usar coroutines que es como esperar a que termine de recibir data para finalizar
    suspend fun getUpcomingMovies():MovieList
    suspend fun getTopRatedMovies():MovieList
    suspend fun getPopularMovies():MovieList
}