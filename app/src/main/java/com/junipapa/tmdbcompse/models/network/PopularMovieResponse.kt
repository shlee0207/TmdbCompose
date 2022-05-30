package com.junipapa.tmdbcompse.models.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse (
    @SerialName("poster_path")
    val posterPath: String,

    val adult: Boolean,
    val overview: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("genre_ids")
    val genreIDS: List<Long>,

    val id: Long,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("original_language")
    val originalLanguage: String,

    val title: String,

    @SerialName("backdrop_path")
    val backdropPath: String,

    val popularity: Double,

    @SerialName("vote_count")
    val voteCount: Long,

    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double
)
