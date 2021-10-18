package com.backjeff.chucknorrisjokes.data.repository

import com.backjeff.chucknorrisjokes.domain.model.Joke

interface JokesRepository {
    fun getRandomJoke(callback: (joke: Joke) -> Unit)
    suspend fun getRandomJokeCoroutine(): Joke
}
