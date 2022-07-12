package com.junipapa.tmdbcompse.models.network

import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    val page: Int,
    val results: List<PopularMovie>,
//    val totalResult: Int,
//    val totalPages: Int
)


//"total_results": 19629,
//"total_pages": 982
