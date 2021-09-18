package com.tobiasstrom.stairs.stats

import com.tobiasstrom.stairs.common.api.FirebaseService
import com.tobiasstrom.stairs.track.TrackViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cModule = module {
    single { FirebaseService() }
    viewModel{ StatsViewModel(get()) }
}
