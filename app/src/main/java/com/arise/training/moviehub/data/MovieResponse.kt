package com.arise.training.moviehub.data

import com.arise.training.moviehub.data.Constants.IMAGE_BASE_URL
import com.arise.training.moviehub.domain.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val id: Int?,
    @SerializedName("poster_path") val posterUrl: String?,
    val title: String?,
    @SerializedName("overview") val description: String?
) {
    fun mapToDomain() = Movie(
        id = id ?: -1,
        posterUrl = "$IMAGE_BASE_URL$posterUrl",
        title = title ?: "",
        description = description ?: ""
    )
}