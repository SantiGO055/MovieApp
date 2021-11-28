package com.cursokotlin.movieapp.data.remote

import com.cursokotlin.movieapp.data.model.MovieList
import com.cursokotlin.movieapp.repository.WebService
import com.cursokotlin.movieapp.utils.AppConstants

class MovieDataSource(private val webService: WebService) {
    //codigo que llamara a servidor para traer la info desde retrofit

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList {
        return webService.getPopularMovies(AppConstants.API_KEY)
    }
}