package com.cursokotlin.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursokotlin.movieapp.databinding.FragmentMovieBinding

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

    //    onviewcreated se llama despues de onCreateView que este es cuando se inicializa el
    //    fragmento cuando esta clase hereda de Fragment y se le pasa el fragmento al constructor
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding = FragmentMovieBinding.bind(view)
        binding.progressBar.visibility = View.GONE
        super.onViewCreated(view, savedInstanceState)
    }
}