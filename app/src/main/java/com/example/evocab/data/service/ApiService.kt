package com.example.evocab.data.service

import com.example.evocab.model.*
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query
// convert giao thuc api -> code
interface ApiService {

    @GET(ApiConstant.ENDPOINT.SEARCH_USER)
    suspend fun searchByName(@Query("q") searchKey: String): Root
    @GET(ApiConstant.ENDPOINT.USER.GET_USER)
    suspend fun getUserInfor() : BaseReponseUser


    interface AuthenticationService{
        @POST(ApiConstant.ENDPOINT.AUTHEN.REGISTER)
        suspend fun register(@Body register: RegisterEnity): BaseResponseRegister


        @POST(ApiConstant.ENDPOINT.AUTHEN.LOGIN)
        suspend fun login(@Body login: LoginEnity): BaseResponseLogin

        @POST(ApiConstant.ENDPOINT.AUTHEN.FORGOTPASSWORD)
        suspend fun forgotpassword(@Body forgotPass: ForgotPassEnity): BaseReponseForgotPass
    }
    interface User{
        //chưa sửa
        @PATCH(ApiConstant.ENDPOINT.USER.PATCH_USER)
        suspend fun changUsername(): BaseReponseSetting
    }

}