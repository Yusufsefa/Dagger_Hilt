package com.yyusufsefa.dependencyinjection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yyusufsefa.dependencyinjection.R
import com.yyusufsefa.dependencyinjection.databinding.FragmentHomeBinding
import com.yyusufsefa.dependencyinjection.ui.adapter.MovieAdapter
import com.yyusufsefa.dependencyinjection.util.Status
import com.yyusufsefa.dependencyinjection.util.hide
import com.yyusufsefa.dependencyinjection.util.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewmodel: MovieViewModel by viewModels()

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentHomeBinding>(
        inflater,
        R.layout.fragment_home,
        container,
        false
    ).also {
        binding = it
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editSearch.addTextChangedListener {
            viewmodel.getMovieData(it.toString())
        }

        initUI()
        observeMovie()

    }


    private fun initUI() {
        movieAdapter = MovieAdapter()
        binding.rcyc.adapter = movieAdapter

        movieAdapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            findNavController().navigate(action)

        }
    }

    private fun observeMovie() {
        viewmodel.movieData.observe(viewLifecycleOwner, {
            when (it.status) {

                Status.LOADING -> {
                    binding.progressBar.show()
                }

                Status.SUCCESS -> {
                    binding.progressBar.hide()
                    movieAdapter.submitList(it.data)
                    movieAdapter.notifyDataSetChanged()
                }

                Status.ERROR -> {
                    binding.progressBar.hide()
                }

            }
        })
    }

}