package com.arise.training.moviehub.data

import com.arise.training.moviehub.data.Constants.API_KEY
import com.arise.training.moviehub.domain.Movie
import com.arise.training.moviehub.domain.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(val apiService: MovieApiService) : MovieRepository {

    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return flow {
            emit(apiService.getPopularMovies(API_KEY, 1))
        }.map {
            it.mapToDomain()
        }
    }
}