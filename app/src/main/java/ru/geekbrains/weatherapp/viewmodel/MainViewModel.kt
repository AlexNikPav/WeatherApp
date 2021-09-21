package ru.geekbrains.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.weatherapp.models.Repository
import ru.geekbrains.weatherapp.models.RepositoryImpl
import java.lang.Exception

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)

            val appState: AppState
            if ((0..9).random() < 5) {
                appState = AppState.Success(repositoryImpl.getWeatherFromLocalStorage())
            } else {
                appState = AppState.Error(Exception("Что-то пошло не так"))
            }

            liveDataToObserve.postValue(appState)
        }.start()
    }
}