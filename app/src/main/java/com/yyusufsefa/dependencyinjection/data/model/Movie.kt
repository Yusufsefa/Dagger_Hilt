package com.yyusufsefa.dependencyinjection.data.model

import java.io.Serializable


data class Movie(
    val Title: String? = null,
    val Year: String? = null,
    val imdbID: String? = null,
    val Type: String? = null,
    val Poster: String? = null
) : Serializable