package com.tobiasstrom.stairs.common

import com.tobiasstrom.stairs.common.service.*
import org.koin.dsl.module

val commonModule = module {
    single<RemoteConfig> {
        FirebaseRemoteConfigRepository()
    }
    single<PreferenceService> { DataStorePreferences(get()) }
    single<AnalyticsService> { FirebaseAnalyticsService(get()) }
    single<ReviewService> { GoogleReviewService(get()) }
}
