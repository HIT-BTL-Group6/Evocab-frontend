package com.example.evocab.di

import com.example.evocab.data.datasource.Topic.ITopicDataSource
import com.example.evocab.data.datasource.Topic.TopicDataSource
import com.example.evocab.data.datasource.forgotpassword.ForgotPassRemoteDataSource
import com.example.evocab.data.datasource.forgotpassword.IForgotPassDataSource
import com.example.evocab.data.datasource.home.HomeRemoteDataSource
import com.example.evocab.data.datasource.home.IHomeDataSource
import com.example.evocab.data.datasource.login.ILoginDataSource
import com.example.evocab.data.datasource.login.LoginRemoteDataSource
import com.example.evocab.data.datasource.register.IRegisterDataSource
import com.example.evocab.data.datasource.register.RegisterRemoteDataSource
import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.data.datasource.search.SearchRemoteDataSource
import com.example.evocab.data.datasource.setting.ISettingDataSource
import com.example.evocab.data.datasource.setting.SettingRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<IRegisterDataSource.Remote> { RegisterRemoteDataSource(get()) }
    single<ILoginDataSource.Remote> { LoginRemoteDataSource(get()) }
    single<IForgotPassDataSource.Remote> { ForgotPassRemoteDataSource(get()) }
    single<IHomeDataSource.Remote> { HomeRemoteDataSource(get()) }
    single<ISettingDataSource.Remote> { SettingRemoteDataSource(get()) }
    single<ITopicDataSource.Remote> { TopicDataSource(get()) }
}