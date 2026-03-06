package com.example.android_dolg.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    id: String,
    viewModel: PeopleViewModel = hiltViewModel()
) {

    LaunchedEffect(id) {
        viewModel.loadDetail(id)
    }

    val state = viewModel.detailState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        when (state) {

            UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Error -> {
                Column {
                    Text(state.message)
                    Button(onClick = { viewModel.loadDetail(id) }) {
                        Text("Retry")
                    }
                }
            }

            is UiState.Success -> {
                val person = state.data
                Column {
                    Text(
                        text = person.name,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Gender: ${person.gender}")
                    Text("Age: ${person.age}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(person.description)
                }
            }
        }
    }
}