package com.example.evocab

import android.app.Application
import com.example.evocab.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EvocabApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        //chayj dau
        startKoin {
            androidContext(this@EvocabApplication)
            modules(
                networkModule,
                apiModule,
                dataSourceModule,
                repositoryModule,
                viewModelModule,
                sharedPreferencesModule,
            )
        }
    }
}