package com.arise.training.moviehub.data

import com.arise.training.moviehub.domain.Movie

data class MovieListResponse(
    val page: Int?,
    val results: List<MovieResponse>?
) {
    fun mapToDomain(): List<Movie> = results?.map { it.mapToDomain() } ?: listOf()
}
