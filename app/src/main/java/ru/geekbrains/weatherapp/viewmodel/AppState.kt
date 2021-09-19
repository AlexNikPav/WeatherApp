package ru.geekbrains.weatherapp.viewmodel

import ru.geekbrains.weatherapp.models.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}

