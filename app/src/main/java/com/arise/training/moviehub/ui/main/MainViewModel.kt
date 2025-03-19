package com.arise.training.moviehub.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arise.training.moviehub.domain.GetPopularListUseCase
import com.arise.training.moviehub.domain.Movie
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    val getPopularListUseCase: GetPopularListUseCase
): ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

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

    fun executeGetPopularList() {
        viewModelScope.launch {
            getPopularListUseCase()
                .onStart {
                    _isLoading.value = true
                }
                .onCompletion {
                    _isLoading.value = false
                }
                .collect {
                    _movies.value = it
                    _filterMovies.value = it
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