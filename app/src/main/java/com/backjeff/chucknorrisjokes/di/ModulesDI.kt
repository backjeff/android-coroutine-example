package com.backjeff.chucknorrisjokes.di

import com.backjeff.chucknorrisjokes.data.remote.ChuckNorrisJokesService
import com.backjeff.chucknorrisjokes.data.remote.core.WebServiceFactory
import com.backjeff.chucknorrisjokes.data.remote.mapper.JokeMapper
import com.backjeff.chucknorrisjokes.data.repository.JokesRepository
import com.backjeff.chucknorrisjokes.data.repository.JokesRepositoryImpl
import com.backjeff.chucknorrisjokes.domain.interactor.GetRandomJokeUseCase
import com.backjeff.chucknorrisjokes.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    factory {
        JokeMapper()
    }

    factory {
        WebServiceFactory.createWebService(
            type = ChuckNorrisJokesService::class.java,
            url = "https://api.chucknorris.io/"
        )
    }

    factory<JokesRepository> {
        JokesRepositoryImpl()
    }

    factory {
        GetRandomJokeUseCase(
            jokesRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            jokesRepository = get(),
            getRandomJokeUseCase = get()
        )
    }
}
