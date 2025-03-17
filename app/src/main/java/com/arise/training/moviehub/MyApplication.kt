package com.arise.training.moviehub

import android.app.Application
import com.arise.training.moviehub.data.MovieRepositoryImpl
import com.arise.training.moviehub.domain.GetPopularListUseCase
import com.arise.training.moviehub.domain.MovieRepository
import timber.log.Timber


class MyApplication: Application() {

    val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl()  // Using Mock Repository for now
    }

    val getPopularMoviesUseCase: GetPopularListUseCase by lazy {
        GetPopularListUseCase(movieRepository)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}