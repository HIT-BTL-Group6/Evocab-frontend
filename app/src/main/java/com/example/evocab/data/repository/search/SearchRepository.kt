package com.example.evocab.data.repository.search

import com.example.evocab.base.DataResult
import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.model.Root
import com.example.sourcebase.base.BaseReponsitory

class SearchRepository(private val remote: ISearchDataSource.Remote): BaseReponsitory(), ISearchRepository {

    override suspend fun searchByName(searchKey: String): DataResult<Root> {
        return getResult { remote.searchByName(searchKey) }
    }
}