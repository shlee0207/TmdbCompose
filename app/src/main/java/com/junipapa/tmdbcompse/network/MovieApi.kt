package com.junipapa.tmdbcompse.network

import com.junipapa.tmdbcompse.models.network.PopularMovieResponse
import retrofit2.http.GET

interface MovieApi {
    @GET("3/movie/popular")
    suspend fun fetchPopularMovies(): PopularMovieResponse

    @GET("")
    suspend fun fetchMovieDetail(id: Long)
}
