package ru.geekbrains.weatherapp.models

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}