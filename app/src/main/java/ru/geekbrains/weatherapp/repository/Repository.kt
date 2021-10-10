package ru.geekbrains.weatherapp.repository

import ru.geekbrains.weatherapp.models.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}