package com.example.evocab.di

import com.example.evocab.ui.flashcard.FlashCardViewModel
import com.example.evocab.ui.forgotpass.ForgotPassViewModel
import com.example.evocab.ui.home.HomeViewModel
import com.example.evocab.ui.login.LoginViewModel
import com.example.evocab.ui.profile.ProfileViewModel
import com.example.evocab.ui.register.SignupViewModel
import com.example.evocab.ui.setting.SettingViewModel
import com.example.evocab.ui.topic.TopicViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignupViewModel(get()) }
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { ForgotPassViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { SettingViewModel(get(), get(), get()) }
    viewModel { TopicViewModel(get()) }
    viewModel { FlashCardViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}
