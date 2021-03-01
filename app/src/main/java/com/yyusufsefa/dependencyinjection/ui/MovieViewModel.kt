package com.yyusufsefa.dependencyinjection.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yyusufsefa.dependencyinjection.data.model.Movie
import com.yyusufsefa.dependencyinjection.data.repository.MovieRepository
import com.yyusufsefa.dependencyinjection.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _movieData = MutableLiveData<Resource<List<Movie>>>()
    val movieData: LiveData<Resource<List<Movie>>> get() = _movieData

    fun getMovieData(query: String) {
        viewModelScope.launch {
            _movieData.postValue(Resource.loading())

            movieRepository.getMovie(query).let {
                _movieData.postValue(Resource.success(it.data?.movie.orEmpty()))
            }
        }
    }

}