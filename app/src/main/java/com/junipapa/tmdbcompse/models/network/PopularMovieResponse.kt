package com.junipapa.tmdbcompse.models.network

import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    val page: Int,
    val results: List<PopularMovie>
)
