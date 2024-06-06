package di

import data.ApiServiceImpl
import domain.remote.ApiService
import org.koin.core.context.startKoin
import org.koin.dsl.module
import presentation.NewsViewModel


//
// Created by Code For Android on 05/06/24.
// Copyright (c) 2024 CFA. All rights reserved.
//

val appModule = module {
    single<ApiService> {
        ApiServiceImpl()
    }
    factory {
        NewsViewModel(get())
    }
}

fun initializeKoin() {

    startKoin {
        modules(appModule)
    }

}