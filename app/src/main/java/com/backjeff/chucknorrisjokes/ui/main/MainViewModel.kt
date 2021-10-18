package com.backjeff.chucknorrisjokes.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.backjeff.chucknorrisjokes.data.repository.JokesRepository
import com.backjeff.chucknorrisjokes.domain.interactor.GetRandomJokeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val jokesRepository: JokesRepository,
    private val getRandomJokeUseCase: GetRandomJokeUseCase
) : ViewModel() {

    private val _joke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val joke = _joke as LiveData<String>

    fun getRandomJoke() {
        jokesRepository.getRandomJoke {
            _joke.postValue(it.text)
        }
    }

    fun getRandomJokeCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {
            val joke = jokesRepository.getRandomJokeCoroutine()
            _joke.value = joke.text
        }
    }

    fun getRandonJokeUseCase() {
        getRandomJokeUseCase(
            onSuccess = { _joke.value = it.text },
            onError = { /* error handling */ }
        )
    }
}
