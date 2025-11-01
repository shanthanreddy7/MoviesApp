package com.example.moviesapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.moviesapp.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(apiKey: String, viewModel: MovieViewModel = viewModel()) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Movies App") }) }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search movies") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { viewModel.searchMovies(apiKey, query) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Search")
            }

            Spacer(Modifier.height(16.dp))
            LazyColumn {
                items(viewModel.movies) { movie ->
                    Row(Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(movie.Poster),
                            contentDescription = movie.Title,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text(movie.Title, style = MaterialTheme.typography.titleMedium)
                            Text("Year: ${movie.Year}")
                        }
                    }
                }
            }
        }
    }
}
