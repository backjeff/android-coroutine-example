package com.backjeff.chucknorrisjokes.data.remote

import com.backjeff.chucknorrisjokes.data.remote.model.JokeRemote
import retrofit2.http.GET

interface ChuckNorrisJokesService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeRemote
}
