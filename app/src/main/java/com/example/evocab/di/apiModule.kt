package com.example.evocab.di

import com.example.evocab.data.service.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(ApiService::class.java) }
}