package com.example.evocab.di

import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.data.repository.search.ISearchRepository
import com.example.evocab.data.repository.search.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ISearchRepository> { SearchRepository(get()) }
}