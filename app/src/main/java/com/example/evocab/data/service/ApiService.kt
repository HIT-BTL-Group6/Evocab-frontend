package com.example.evocab.data.service

import com.example.evocab.model.*
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
// convert giao thuc api -> code
interface ApiService {

    @GET(ApiConstant.ENDPOINT.SEARCH_USER)
    suspend fun searchByName(@Query("q") searchKey: String): Root


    interface AuthenticationService{
        @POST(ApiConstant.ENDPOINT.REGISTER)
        suspend fun register(@Body register: UserRequestRegister): BaseResponseRegister


        @POST(ApiConstant.ENDPOINT.LOGIN)
        suspend fun login(@Body login: UserRequestLogin): BaseResponseLogin
    }
}