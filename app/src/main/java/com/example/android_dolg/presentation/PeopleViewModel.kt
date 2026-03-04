package com.example.android_dolg.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_dolg.domain.PeopleRepository
import com.example.android_dolg.domain.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: PeopleRepository
) : ViewModel() {

    var peopleState = mutableStateOf<UiState<List<Person>>>(UiState.Loading)
        private set

    var detailState = mutableStateOf<UiState<Person>>(UiState.Loading)
        private set

    init {
        loadPeople()
    }

    fun loadPeople() {
        viewModelScope.launch {
            peopleState.value = UiState.Loading
            repository.getPeople()
                .onSuccess { peopleState.value = UiState.Success(it) }
                .onFailure { peopleState.value = UiState.Error(it.message ?: "Error") }
        }
    }

    fun loadDetail(id: String) {
        viewModelScope.launch {
            detailState.value = UiState.Loading
            repository.getPersonById(id)
                .onSuccess { detailState.value = UiState.Success(it) }
                .onFailure { detailState.value = UiState.Error(it.message ?: "Error") }
        }
    }
}