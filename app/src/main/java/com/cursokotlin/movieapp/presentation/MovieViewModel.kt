package com.cursokotlin.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.cursokotlin.movieapp.core.Resource
import com.cursokotlin.movieapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class MovieViewModel(private val repo: MovieRepository): ViewModel() {
    //capa entre repositorio y la ui

    fun fetchMainScreenMovies() =
        liveData(Dispatchers.IO) //realizamos llamada en otro hilo de ejecucion con Dispatchers.io
        {
            //emitimos valor de carga
            emit(Resource.Loading())

            try {
                //uso Triple para retornar 3 llamadas
                emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies())))
            }
            catch (e: Exception){
                emit(Resource.Failure(e))
            }

        }
}

class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
//para retornar 4 datos o mas agregandolos
data class  NTuple4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4)