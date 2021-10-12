package ru.geekbrains.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.weatherapp.app.App
import ru.geekbrains.weatherapp.repository.LocalRepository
import ru.geekbrains.weatherapp.repository.LocalRepositoryImpl

class HistoryViewModel(
    val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val historyRepository: LocalRepository = LocalRepositoryImpl(App.getHistoryDao())
) : ViewModel() {

    fun getAllHistory() {
        historyLiveData.value = AppState.Loading
        Thread {
            historyLiveData.postValue(
                AppState.Success(historyRepository.getAllHistory())
            )
        }.start()
    }
}