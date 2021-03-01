package com.yyusufsefa.dependencyinjection.data.model

class MovieItemViewState(
    val movie: Movie
) {
    fun movieTittle() = movie.Title ?: ""

    fun movieImageUrl() = movie.Poster ?: ""

}