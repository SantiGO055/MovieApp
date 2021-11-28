package com.cursokotlin.movieapp.repository

import com.cursokotlin.movieapp.data.model.MovieList
import com.cursokotlin.movieapp.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {

    //suspend es para usar coroutines que es como esperar a que termine de recibir data para finalizar

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies() //esto es lo mismo que poner return dentro de llaves

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}