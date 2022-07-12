package com.junipapa.tmdbcompse.models.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovie(
    @SerialName("id") val id: Long,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("genre_ids") val genreIDS: List<Long>,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("backdrop_path") val backdropPath: String,
    @SerialName("vote_count") val voteCount: Long,
    val adult: Boolean,
    val overview: String,
    val title: String,
    val popularity: Double,
    val video: Boolean
)
