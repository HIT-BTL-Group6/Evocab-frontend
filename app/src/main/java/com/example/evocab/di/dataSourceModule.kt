package com.example.evocab.di

import com.example.evocab.data.datasource.register.IRegisterDataSource
import com.example.evocab.data.datasource.register.RegisterRemoteDataSource
import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.data.datasource.search.SearchRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<ISearchDataSource.Remote> { SearchRemoteDataSource(get()) }
    single<IRegisterDataSource.Remote> { RegisterRemoteDataSource(get()) }
}