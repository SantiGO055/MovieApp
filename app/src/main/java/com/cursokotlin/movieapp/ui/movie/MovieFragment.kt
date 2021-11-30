package com.cursokotlin.movieapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cursokotlin.movieapp.R
import com.cursokotlin.movieapp.core.Resource
import com.cursokotlin.movieapp.data.remote.MovieDataSource
import com.cursokotlin.movieapp.databinding.FragmentMovieBinding
import com.cursokotlin.movieapp.presentation.MovieViewModel
import com.cursokotlin.movieapp.presentation.MovieViewModelFactory
import com.cursokotlin.movieapp.repository.MovieRepositoryImpl
import com.cursokotlin.movieapp.repository.RetrofitClient
import com.cursokotlin.movieapp.repository.WebService

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding

    //uso by para delegar a otro lado
    //inyeccion de dependencias manual
    //desde un objeto inyectamos una dependencia y desde este inyectamos otra y dentro pasamos el webservice
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webService)
    )) }

    //    onviewcreated se llama despues de onCreateView que este es cuando se inicializa el
    //    fragmento cuando esta clase hereda de Fragment y se le pasa el fragmento al constructor
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding = FragmentMovieBinding.bind(view)


        //al hacer el viewmodel repito 3 veces los metodos y necesito especificar el orden de los metodos para que primero traiga upcoming, luego popular y luego toprated

        //observo y espero a retornar la data
        //hay que tener cuidado del observe ya que si cierro el fragment y vuelvo a renderizarlo provoca que se ejecute dos veces, para eso se usa: viewLifecycleOwner,
        // no hace falta hacer unsuscribe o destruir el observe


        //voy anidando las llamadas pero esto esta mal visto, no se puede anidar tantas, si una da failure no continua a la otra
        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner,{ result->
            when(result){
                is Resource.Loading -> {
                    Log.d("LiveDataUpcoming","Loading...")
                    binding.rlProgressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("LiveDataUpcoming","Upcoming: ${result.data.first} \n \n Top rated: ${result.data.second} \n \n Popular: ${result.data.third}")
                    binding.rlProgressBar.visibility = View.GONE

                }
                is Resource.Failure -> {
                    Log.d("Error","${result.exception}")
                    binding.rlProgressBar.visibility = View.GONE

                }
            }
        })



        super.onViewCreated(view, savedInstanceState)
    }
}