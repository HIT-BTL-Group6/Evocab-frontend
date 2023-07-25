package com.example.evocab.data.datasource.search

import com.example.evocab.model.Root

// dinh nghix cacs lop tra ve du lieu
interface ISearchDataSource {
    interface Remote{
        suspend fun searchByName(searchKey: String): Root
    }
    interface Local{

    }
}