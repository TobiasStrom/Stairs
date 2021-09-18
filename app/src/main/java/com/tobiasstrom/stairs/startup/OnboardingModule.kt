package com.tobiasstrom.stairs.startup

import com.tobiasstrom.stairs.startup.view.OnboardingViewModel
import com.tobiasstrom.stairs.startup.view.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    viewModel<OnboardingViewModel>()
    viewModel<SplashViewModel>()
}
