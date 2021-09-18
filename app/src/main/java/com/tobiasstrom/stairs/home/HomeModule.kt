package com.tobiasstrom.stairs.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val aModule = module {
    viewModel<HomeViewModel>()
}
