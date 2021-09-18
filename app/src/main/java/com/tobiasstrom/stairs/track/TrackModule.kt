package com.tobiasstrom.stairs.track

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bModule = module {
    viewModel<TrackViewModel>()
}
