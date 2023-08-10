package com.example.evocab.di

import android.content.SharedPreferences
import com.atom.android.lebo.utils.extensions.getTokenLogin
import com.example.evocab.utils.constant.ApiConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
}

private fun provideOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val okHttpClient = OkHttpClient.Builder()
    okHttpClient
        .connectTimeout(ApiConstant.TIMEOUT.CONNECT, TimeUnit.SECONDS)
        .readTimeout(ApiConstant.TIMEOUT.READ, TimeUnit.SECONDS)
        .writeTimeout(ApiConstant.TIMEOUT.WRITE, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor { chain ->
            val authorRequest = chain.request().newBuilder()
                .header(
                    ApiConstant.AUTHORIZATION,
                    "${ApiConstant.BEARER} ${sharedPreferences.getTokenLogin()}"
                )
                .build()
            chain.proceed(authorRequest)
        }
    return okHttpClient.build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(ApiConstant.URL.BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

