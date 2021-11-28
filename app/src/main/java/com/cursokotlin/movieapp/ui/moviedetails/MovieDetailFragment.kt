package com.cursokotlin.movieapp.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursokotlin.movieapp.R
import com.cursokotlin.movieapp.databinding.FragmentMovieBinding
import com.cursokotlin.movieapp.databinding.FragmentMovieDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

//    uso private lateinit var: es una promesa de que voy a inicializarlo luego en algun momento de ejecucion
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMovieDetailBinding.bind(view)

        super.onViewCreated(view, savedInstanceState)
    }

}