package com.tobiasstrom.stairs.track

import com.tobiasstrom.stairs.common.api.FirebaseService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val trackModule = module {
    single { FirebaseService() }
    viewModel{TrackViewModel(get())}
}
