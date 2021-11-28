package com.cursokotlin.movieapp.repository

import com.cursokotlin.movieapp.data.model.MovieList
import com.cursokotlin.movieapp.utils.AppConstants
import com.cursokotlin.movieapp.utils.AppConstants.API_KEY
import com.cursokotlin.movieapp.utils.AppConstants.BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    //suspend es para usar coroutines que es como esperar a que termine de recibir data para finalizar

    //https://api.themoviedb.org/3/movie/upcoming?api_key=8aa03428d1666b2c21ad79d3a542b846&language=en-US&page=1

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): MovieList

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): MovieList

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieList
}

object RetrofitClient{
    //se usa lazy para cuando llamemos a retrofitclient.webservice inicializa solo en el momento que llame a webservice y no antes
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //convertimos la data que llega a gson
            .build().create(WebService::class.java)
    }
}