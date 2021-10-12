package ru.geekbrains.weatherapp.repository

import ru.geekbrains.weatherapp.models.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}