package com.yyusufsefa.dependencyinjection.ui

import com.yyusufsefa.dependencyinjection.data.model.Movie

class DetailMovieViewState(
    private val movie: Movie
) {
    fun movieName() = movie.Title ?: ""

    fun movieImageUrl() = movie.Poster ?: ""

    fun movieYear() = movie.Year ?: ""

    fun movieType() = movie.Type ?: ""
}