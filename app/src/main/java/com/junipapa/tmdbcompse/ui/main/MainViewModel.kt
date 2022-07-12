package com.junipapa.tmdbcompse.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junipapa.tmdbcompse.models.network.PopularMovie
import com.junipapa.tmdbcompse.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    movieRepository: MovieRepository
) : ViewModel() {
    var movies: MutableState<List<PopularMovie>> = mutableStateOf(mutableListOf())
    private val movieFlow = movieRepository.loadPopularMovies(
        success = {},
        error = {}
    ).shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieFlow.collectLatest {
                movies.value = it
            }
        }
    }
}
