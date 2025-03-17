package com.arise.training.moviehub.domain

import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
}