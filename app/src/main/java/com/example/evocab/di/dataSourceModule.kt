package com.example.evocab.di

import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.data.datasource.search.SearchRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<ISearchDataSource.Remote> { SearchRemoteDataSource(get()) }

}