package com.example.evocab.di

import com.example.evocab.data.datasource.search.ISearchDataSource
import com.example.evocab.data.repository.forgotpassword.ForgotpassRepository
import com.example.evocab.data.repository.forgotpassword.IForgotpassRepository
import com.example.evocab.data.repository.home.HomeRepository
import com.example.evocab.data.repository.home.IHomeRepository
import com.example.evocab.data.repository.login.ILoginRepository
import com.example.evocab.data.repository.login.LoginRepository
import com.example.evocab.data.repository.register.IRegisterRepository
import com.example.evocab.data.repository.register.RegisterRepository
import com.example.evocab.data.repository.search.ISearchRepository
import com.example.evocab.data.repository.search.SearchRepository
import com.example.evocab.data.repository.setting.ISettingRepository
import com.example.evocab.data.repository.setting.SettingRepository
import com.example.evocab.data.repository.topic.ITopicRepository
import com.example.evocab.data.repository.topic.TopicRepository
import org.koin.dsl.module

val repositoryModule = module {
    //single<ISearchRepository> { SearchRepository(get()) }
    single<IRegisterRepository> { RegisterRepository(get()) }
    single<ILoginRepository> { LoginRepository(get()) }
    single<IForgotpassRepository> { ForgotpassRepository(get()) }
    single<IHomeRepository> { HomeRepository(get()) }
    single<ISettingRepository> { SettingRepository(get()) }
    single<ITopicRepository> { TopicRepository(get()) }
}