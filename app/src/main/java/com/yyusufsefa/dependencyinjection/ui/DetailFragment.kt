package com.yyusufsefa.dependencyinjection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.yyusufsefa.dependencyinjection.R
import com.yyusufsefa.dependencyinjection.data.model.Movie
import com.yyusufsefa.dependencyinjection.databinding.FragmentDetailBinding


class DetailFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDetailBinding

    private lateinit var movie: Movie


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentDetailBinding>(
        inflater,
        R.layout.fragment_detail,
        container,
        false
    ).also {
        binding = it
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeMovie()
        initUI()

    }

    private fun initUI() {
        binding.itemViewState = DetailMovieViewState(movie)
    }

    private fun observeMovie() {
        arguments.let {
            movie = DetailFragmentArgs.fromBundle(it!!).movie
        }
    }


}