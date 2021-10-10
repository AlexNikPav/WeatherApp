package ru.geekbrains.weatherapp.utils

import ru.geekbrains.weatherapp.models.FactDTO
import ru.geekbrains.weatherapp.models.Weather
import ru.geekbrains.weatherapp.models.WeatherDTO
import ru.geekbrains.weatherapp.models.getDefaultCity

fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact: FactDTO = weatherDTO.fact!!
    return listOf(Weather(getDefaultCity(), fact.temp!!, fact.feels_like!!, fact.condition!!))
}