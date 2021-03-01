package com.yyusufsefa.dependencyinjection.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("success") val status: Boolean? = null,
    @SerializedName("result") val movie: List<Movie>? = null
)