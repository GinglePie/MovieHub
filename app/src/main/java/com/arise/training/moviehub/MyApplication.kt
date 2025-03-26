package com.arise.training.moviehub

import android.app.Application
import com.arise.training.moviehub.data.MovieApiService
import com.arise.training.moviehub.data.MovieRepositoryImpl
import com.arise.training.moviehub.data.RetrofitFactory.createRetrofit
import com.arise.training.moviehub.domain.GetPopularMoviesUseCase
import com.arise.training.moviehub.domain.MovieRepository
import timber.log.Timber


class MyApplication: Application() {

    private val movieApiService: MovieApiService by lazy {
        createRetrofit(this).create(MovieApiService::class.java)
    }

    private val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl(movieApiService)
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