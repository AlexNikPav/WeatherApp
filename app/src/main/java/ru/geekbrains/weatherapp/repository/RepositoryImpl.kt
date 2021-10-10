package ru.geekbrains.weatherapp.repository

import ru.geekbrains.weatherapp.models.Weather
import ru.geekbrains.weatherapp.models.getRussianCities
import ru.geekbrains.weatherapp.models.getWorldCities

class RepositoryImpl : Repository {

    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()

}