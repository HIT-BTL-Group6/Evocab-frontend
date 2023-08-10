package com.example.evocab.di

import android.app.Application
import android.content.SharedPreferences
import com.example.evocab.utils.constant.Constant
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single {
        getSharedPrefs(androidApplication())
    }

    single<SharedPreferences.Editor> {
        getSharedPrefs(androidApplication()).edit()
    }
}

fun getSharedPrefs(androidApplication: Application): SharedPreferences {
    return androidApplication.getSharedPreferences(
        Constant.SHARED_PREF_ROOT,
        android.content.Context.MODE_PRIVATE
    )
}