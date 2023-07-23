package com.example.evocab.data.datasource.search

import com.example.evocab.data.service.ApiService
import com.example.evocab.model.Root

class SearchRemoteDataSource(private val service: ApiService):ISearchDataSource.Remote {

    override suspend fun searchByName(searchKey: String): Root {
        return service.searchByName(searchKey)
    }
}