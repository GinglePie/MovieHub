package com.arise.training.moviehub.data

import com.arise.training.moviehub.domain.Movie
import com.arise.training.moviehub.domain.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl : MovieRepository {

    val mockMovies = mutableListOf<Movie>()

    override suspend fun getPopularMovies(): Flow<List<Movie>> = flow {
        delay(300)
        mockMovies.clear()
        for (i in 0..100) {
            mockMovies.add(
                Movie(
                    id = i,
                    title = "Spider-Man: $i",
                    posterPath = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                    overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero.",
                    releaseDate = "2021-12-15",
                    voteAverage = 8.2f
                )
            )
        }
        emit(mockMovies.toList())
    }
}