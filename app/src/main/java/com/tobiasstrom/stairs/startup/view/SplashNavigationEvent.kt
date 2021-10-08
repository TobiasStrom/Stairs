package com.tobiasstrom.stairs.startup.view

sealed class SplashNavigationEvent(){
    object SplashNavigationVersionLock : SplashNavigationEvent()

    object SplashNavigationOnboarding : SplashNavigationEvent()

    object SplashNavigationMain : SplashNavigationEvent()

    object SplashNavigationLogin : SplashNavigationEvent()

}

