package com.arise.training.moviehub.data

import com.arise.training.moviehub.domain.Movie
import com.arise.training.moviehub.domain.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl : MovieRepository {

    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        val mockMovies = mutableListOf<Movie>()
        for (i in 0 until 100) {
            mockMovies.add(
                Movie(
                    id = i,
                    title = "Name $i",
                    description = "Description $i",
                    posterUrl = "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*")
            )
        }
        return flow {
            delay(5000)
            emit(mockMovies)
        }
    }
}