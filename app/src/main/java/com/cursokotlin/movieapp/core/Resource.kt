package com.cursokotlin.movieapp.core

import java.lang.Exception

//selaed class uso para todas las peticiones que tenga en la app
//El generics T lo uso para devolver el tipo de dato que yo quiera

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val exception: Exception): Resource<T>()

}