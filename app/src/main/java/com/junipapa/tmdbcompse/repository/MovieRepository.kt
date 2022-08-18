package com.junipapa.tmdbcompse.repository

import androidx.annotation.WorkerThread
import com.junipapa.tmdbcompse.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

class MovieRepository(
    private val movieApi: MovieApi
) : Repository {
    @WorkerThread
    fun loadPopularMovies(success: () -> Unit, error: () -> Unit) = flow {
        val response = movieApi.fetchPopularMovies()
        emit(response.results)
    }.onCompletion {
        success()
    }.flowOn(Dispatchers.IO)

}
