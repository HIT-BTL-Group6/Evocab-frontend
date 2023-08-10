package com.example.evocab.di

import com.example.evocab.ui.forgotpass.ForgotPassViewModel
import com.example.evocab.ui.home.HomeViewModel
import com.example.evocab.ui.login.LoginViewModel
import com.example.evocab.ui.register.SignupViewModel
import com.example.evocab.ui.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SettingViewModel(get()) }
    viewModel { SignupViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { ForgotPassViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { SettingViewModel(get()) }
}
