package com.example.evocab

import android.app.Application
import com.example.evocab.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        //chayj dau
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                apiModule,
                dataSourceModule,
                repositoryModule,
                viewModelModule,
            )
        }
    }
}