package com.arise.training.moviehub.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel: ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    init {
        Timber.d("init")
    }

    fun setCounter(value: Int) {
        _number.value = value
    }

    fun counter() {
        _number.value = (_number.value ?: 0) + 1
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
    }
}