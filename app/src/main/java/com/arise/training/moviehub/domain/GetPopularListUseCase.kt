package com.arise.training.moviehub.domain

import kotlinx.coroutines.flow.Flow

class GetPopularListUseCase(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(): Flow<List<Movie>> {
        return repository.getPopularMovies()
    }
}