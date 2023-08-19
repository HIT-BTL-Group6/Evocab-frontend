package com.example.evocab.data.service

import com.example.evocab.model.*
import com.example.evocab.utils.constant.ApiConstant
import retrofit2.http.*

// convert giao thuc api -> code
interface ApiService {


    @GET(ApiConstant.ENDPOINT.SEARCH_USER)
    suspend fun searchByName(@Query("q") searchKey: String): Root

    interface AuthenticationService{
        @POST(ApiConstant.ENDPOINT.AUTHEN.REGISTER)
        suspend fun register(@Body register: RegisterEnity): BaseResponseRegister


        @POST(ApiConstant.ENDPOINT.AUTHEN.LOGIN)
        suspend fun login(@Body login: LoginEnity): BaseResponseLogin

        @POST(ApiConstant.ENDPOINT.AUTHEN.FORGOTPASSWORD)
        suspend fun forgotpassword(@Body forgotPass: ForgotPassEnity): BaseReponseForgotPass
    }
    interface User{
        @GET(ApiConstant.ENDPOINT.USER.GET_USER)
        suspend fun getUserInfor() : BaseReponseUser
        //chưa sửa
        @PATCH("${ApiConstant.ENDPOINT.USER.PATCH_USER_SETTING}/{idUser}")
        suspend fun changUsername(@Path(ApiConstant.FILED.IDUSER) idUser: String, @Body user: UserCanChange): BaseReponseSetting
    }
    interface Topic{
        @GET(ApiConstant.ENDPOINT.TOPIC.GET_TOPIC)
        suspend fun getAllTopic(): BaseReponseTopic

        @GET("${ApiConstant.ENDPOINT.TOPIC.GET_TOPIC}/{idTopic}")
        suspend fun getAllVocabInTopic(@Path(ApiConstant.FILED.IDTOPIC) idTopic: String): ListWord

        @GET("${ApiConstant.ENDPOINT.TOPIC.GET_VOCAB}/{idWord}")
        suspend fun get1Vocab(@Path(ApiConstant.FILED.IDWORD) idWord: String): BaseReponseWord


        @GET("${ApiConstant.ENDPOINT.TOPIC.GET_VOCAB}/{idWord}")
        suspend fun getAllVocabLearned(@Path(ApiConstant.FILED.IDWORD) idWord: String): BaseReponseMissed

        @GET("${ApiConstant.ENDPOINT.TOPIC.GET_VOCAB_REMEMBER}/{idUser}")
        suspend fun getAllVocabRemember(@Path(ApiConstant.FILED.IDUSER) idUser: String): BaseReponseMissed

        //api/v1/user-words/add-word
        @POST("${ApiConstant.ENDPOINT.TOPIC.POST_WORD}/{idUser}")
        suspend fun postWord(@Path(ApiConstant.FILED.IDUSER) idUser: String, wordRemember: WordRemember): BaseReponseMissed

        @PUT("${ApiConstant.ENDPOINT.TOPIC.PUT_WORD_CARD}/{idUser}")
        suspend fun chooseMissedOrRemember(@Path(ApiConstant.FILED.IDUSER) idUser: String, wordRequest: WordRemember): PutWord
    }
}