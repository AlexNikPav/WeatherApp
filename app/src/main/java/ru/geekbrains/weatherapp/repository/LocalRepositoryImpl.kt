package ru.geekbrains.weatherapp.repository

import ru.geekbrains.weatherapp.models.City
import ru.geekbrains.weatherapp.models.Weather
import ru.geekbrains.weatherapp.room.HistoryDao
import ru.geekbrains.weatherapp.room.HistoryEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {

    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}

fun convertHistoryEntityToWeather(entityList: List<HistoryEntity>): List<Weather> {
    return entityList.map {
        Weather(City(it.city, 0.0, 0.0), it.temperature, 0, it.condition)
    }
}

fun convertWeatherToEntity(weather: Weather): HistoryEntity {
    return HistoryEntity(0, weather.city.name, weather.temperature, weather.condition)
}