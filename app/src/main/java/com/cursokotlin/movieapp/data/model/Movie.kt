package com.cursokotlin.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int = -1,
    //@SerializedName("adult") //renombro variables, voy a buscarla al servidor como adult y abajo defino adulto
    val adult: Boolean = false,
    val genre_ids: List<Int> = listOf(), //inicializo lista vacia
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
)

data class MovieList(val results: List<Movie> = listOf())