package com.backjeff.chucknorrisjokes.core

import android.app.Application
import com.backjeff.chucknorrisjokes.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppApplication)
            modules(modules = appModules)
        }
    }
}
