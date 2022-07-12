package com.junipapa.tmdbcompse.di

import com.junipapa.tmdbcompse.network.MovieApi
import com.junipapa.tmdbcompse.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApi: MovieApi
    ): MovieRepository = MovieRepository(movieApi)
}
