package com.example.android_dolg.presentation

sealed class UiState<out T> {

    object Loading : UiState<Nothing>()

    data class Success<T>(val data: T) : UiState<T>()

    data class Error(val message: String) : UiState<Nothing>()
}