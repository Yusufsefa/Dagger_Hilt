package com.yyusufsefa.dependencyinjection.data.repository

import com.yyusufsefa.dependencyinjection.common.BaseRepository
import com.yyusufsefa.dependencyinjection.data.model.MovieResponse
import com.yyusufsefa.dependencyinjection.network.Api
import com.yyusufsefa.dependencyinjection.util.Resource
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api: Api) : BaseRepository() {

    suspend fun getMovie(query: String): Resource<MovieResponse> {
        return getResult {
            api.getMovie(query)
        }
    }

}