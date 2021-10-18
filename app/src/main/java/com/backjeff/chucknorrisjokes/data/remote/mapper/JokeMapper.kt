package com.backjeff.chucknorrisjokes.data.remote.mapper

import com.backjeff.chucknorrisjokes.data.remote.model.JokeRemote
import com.backjeff.chucknorrisjokes.domain.model.Joke

class JokeMapper() {
    fun toDomain(jokeRemote: JokeRemote) = Joke(
        text = jokeRemote.value
    )
}