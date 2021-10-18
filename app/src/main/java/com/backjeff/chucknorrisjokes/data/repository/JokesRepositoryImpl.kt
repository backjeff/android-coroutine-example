package com.backjeff.chucknorrisjokes.data.repository

import com.backjeff.chucknorrisjokes.domain.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class JokesRepositoryImpl : JokesRepository {
    override fun getRandomJoke(callback: (joke: Joke) -> Unit) {
        Thread {
            Thread.sleep(3000)
            callback(
                Joke("Chuck Norris can instantiate an abstract class.")
            )
        }.start()
    }

    override suspend fun getRandomJokeCoroutine(): Joke {
        return withContext(Dispatchers.IO) {
            delay(3000)
            Joke("Chuck Norris can instantiate an abstract class.")
        }
    }
}
