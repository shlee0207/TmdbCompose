package com.junipapa.tmdbcompse.ui.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.junipapa.tmdbcompse.models.network.PopularMovie
import com.junipapa.tmdbcompse.network.Api.getPosterPath
import com.junipapa.tmdbcompse.ui.main.MainViewModel

@Composable
fun MovieScreen(
    viewModel: MainViewModel,
    selectMovie: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val movies by viewModel.movies
    
    LazyColumn {
        items(movies) { movie ->
            MoviePoster(
                movie = movie,
                selectMovie = selectMovie,
            )
        }
    }
}

@Composable
fun MoviePoster(
    movie: PopularMovie,
    selectMovie: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .clickable(
                onClick = { selectMovie(movie.id) }
            )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(getPosterPath(movie.posterPath))
                .crossfade(true)
                .build(),
            contentDescription = ""
        )
    }
}
