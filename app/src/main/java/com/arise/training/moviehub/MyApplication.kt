package com.arise.training.moviehub

import android.app.Application
import com.arise.training.moviehub.data.MovieRepositoryImpl
import com.arise.training.moviehub.domain.GetPopularMoviesUseCase
import com.arise.training.moviehub.domain.MovieRepository
import timber.log.Timber


class MyApplication: Application() {

    private val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl()
    }

    val getPopularMoviesUseCase: GetPopularMoviesUseCase by lazy {
        GetPopularMoviesUseCase(movieRepository)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}