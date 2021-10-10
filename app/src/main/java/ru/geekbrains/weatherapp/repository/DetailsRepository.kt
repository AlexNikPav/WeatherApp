package ru.geekbrains.weatherapp.repository

import ru.geekbrains.weatherapp.models.WeatherDTO

interface DetailsRepository {
    fun getWeatherDetailsFromServer(
        lat: Double,
        lon: Double,
        callback: retrofit2.Callback<WeatherDTO>
    )
}