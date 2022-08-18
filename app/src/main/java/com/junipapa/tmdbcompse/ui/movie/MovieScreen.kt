package com.junipapa.tmdbcompse.ui.movie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.junipapa.tmdbcompse.R.string
import com.junipapa.tmdbcompse.models.network.PopularMovie
import com.junipapa.tmdbcompse.network.Api.getPosterPath
import com.junipapa.tmdbcompse.ui.main.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieScreen(
    viewModel: MainViewModel,
    selectMovie: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { MainAppBar() }
    ) {
        val movies by viewModel.movies
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(movies) { movie ->
                MoviePoster(
                    movie = movie,
                    selectMovie = selectMovie,
                )
            }
        }
    }
}

@Composable
@Preview
fun MainAppBar() {
    TopAppBar(
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            text = stringResource(id = string.home),
            modifier = Modifier
                .padding(10.dp)
                .align(CenterVertically),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
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
            .height(260.dp)
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .clickable(
                onClick = { selectMovie(movie.id) }
            ),
        elevation = 4.dp
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(getPosterPath(movie.posterPath))
                    .crossfade(true)
                    .scale(Scale.FILL)
                    .build(),
                contentScale = ContentScale.FillBounds,
                contentDescription = ""
            )
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.BottomEnd)
            ) {
                val imageVector = Icons.Default.Star
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    tint = Color.Cyan,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Text(
                    text = movie.voteAverage.toString(),
                    modifier = Modifier.align(Center),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}
