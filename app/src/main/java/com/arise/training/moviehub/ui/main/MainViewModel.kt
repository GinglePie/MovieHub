package com.arise.training.moviehub.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arise.training.moviehub.domain.GetPopularMoviesUseCase
import com.arise.training.moviehub.domain.Movie
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _filterMovies = MutableLiveData<List<Movie>>()
    val filterMovies: LiveData<List<Movie>> = _filterMovies

    init {
        Timber.d("init")
    }

    fun setCounter(value: Int) {
        _number.value = value
    }

    fun counter() {
        _number.value = (_number.value ?: 0) + 1
    }

    fun executeGetPopularMovies() {
        viewModelScope.launch {
            getPopularMoviesUseCase()
                .onStart {
                    Timber.d("testapp onStart")
                }
                .onCompletion {
                    Timber.d("testapp onCompletion")
                }
                .collect {
                    _movies.value = it
                    _filterMovies.value = it
                    Timber.d("testapp movies $it")
                }
        }
    }

    fun filterMovies(text: String) {
        _filterMovies.value = movies.value?.filter {
            it.title.contains(text)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
    }
}