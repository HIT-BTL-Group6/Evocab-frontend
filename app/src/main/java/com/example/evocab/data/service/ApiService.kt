package com.example.evocab.data.service

import com.example.evocab.model.Root
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.GET
import retrofit2.http.Query
// convert giao thuc api -> code
interface ApiService {

    @GET(ApiConstant.ENDPOINT.SEARCH_USER)
    suspend fun searchByName(@Query("q") searchKey: String): Root
}