package ru.geekbrains.weatherapp.models

data class FactDTO(
    val temp: Int?,
    val feels_like: Int?,
    val condition: String?,
    val icon: String?
)
