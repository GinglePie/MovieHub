package com.arise.training.moviehub.domain

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Float,
    val isFavorite: Boolean = false
)