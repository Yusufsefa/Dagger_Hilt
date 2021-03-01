package com.yyusufsefa.dependencyinjection.network

import com.yyusufsefa.dependencyinjection.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    //    @Headers(
//        "authorization", "apikey 4TA9feo1TEk8ZD3sDbIeXO:66XfWakrJIp5xFh0dtlgE6"
//    )
    @GET("imdb/imdbSearchByName")
    suspend fun getMovie(
        @Query("query") query: String,
    ): Response<MovieResponse>

}