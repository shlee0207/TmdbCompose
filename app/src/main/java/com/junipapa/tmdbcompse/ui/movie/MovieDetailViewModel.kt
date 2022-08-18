package com.junipapa.tmdbcompse.ui.movie

import com.junipapa.tmdbcompse.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository
) {

}
