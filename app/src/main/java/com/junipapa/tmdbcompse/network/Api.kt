package com.junipapa.tmdbcompse.network

object Api {
    const val BASE_URL = "https://api.themoviedb.org/"
    private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"

    fun getPosterPath(posterPath: String?): String {
        return BASE_POSTER_PATH + posterPath
    }
}
