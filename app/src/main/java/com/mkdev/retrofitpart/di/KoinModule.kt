package com.mkdev.retrofitpart.di

import com.mkdev.retrofitpart.repository.ApiRepository
import com.mkdev.retrofitpart.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { ApiRepository() }

    viewModel{ MainActivityViewModel(get()) }

}