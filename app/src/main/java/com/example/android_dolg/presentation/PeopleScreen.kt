package com.example.android_dolg.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PeopleScreen(
    viewModel: PeopleViewModel = hiltViewModel(),
    onClick: (String) -> Unit
) {

    val state = viewModel.peopleState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Text(
            text = "VariantCode: GHIBLI-PEOPLE-MOD_A2_GRID",
            style = MaterialTheme.typography.labelSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (state) {

            UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Error -> {
                Column {
                    Text(state.message)
                    Button(onClick = { viewModel.loadPeople() }) {
                        Text("Retry")
                    }
                }
            }

            is UiState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.data) { person ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onClick(person.id) }
                        ) {
                            Column(Modifier.padding(12.dp)) {
                                Text(person.name)
                                Text(person.gender)
                                Text("Age: ${person.age}")
                            }
                        }
                    }
                }
            }
        }
    }
}