package com.tobiasstrom.stairs.startup.view

import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import com.tobiasstrom.stairs.common.livedata.Event
import com.tobiasstrom.stairs.common.service.PreferenceService
import com.tobiasstrom.stairs.common.service.RemoteConfig

class SplashViewModel(
    remoteConfig: RemoteConfig,
    preferences: PreferenceService
) : ViewModel() {

    private val _navigationEvent = MutableLiveData<SplashNavigationEvent>()
    val navigationEvent = _navigationEvent.map(::Event)
    //private var auth: FirebaseAuth = Firebase.auth

    init {
        viewModelScope.launch(Dispatchers.IO) {
            remoteConfig.init()
            when {

                remoteConfig.isVersionLocked() -> _navigationEvent.postValue(
                    SplashNavigationEvent.SplashNavigationVersionLock
                )
                preferences.onboardingCompleted.first() -> _navigationEvent.postValue(
                    SplashNavigationEvent.SplashNavigationOnboarding
                )

                else -> _navigationEvent.postValue(SplashNavigationEvent.SplashNavigationMain)
            }
        }
    }
}
