package com.backjeff.chucknorrisjokes.domain.interactor

import com.backjeff.chucknorrisjokes.data.repository.JokesRepository
import com.backjeff.chucknorrisjokes.domain.model.Joke
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetRandomJokeUseCase(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke(
        onError: ((Throwable) -> Unit) = {},
        onSuccess: (Joke) -> Unit = {},
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = jokesRepository.getRandomJokeCoroutine()
                withContext(Dispatchers.Main) {
                    onSuccess(result)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }
}
