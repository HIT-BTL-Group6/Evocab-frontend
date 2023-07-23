package com.example.evocab.data.repository.search

import com.example.evocab.model.Root
import com.example.evocab.base.DataResult

// chuyen doi duw lieuj vef dangj dataresult (sucess, errrer)
interface ISearchRepository {
    suspend fun searchByName(searchKey: String): DataResult<Root>
}