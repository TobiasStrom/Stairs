package com.tobiasstrom.stairs.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.tobiasstrom.stairs.common.livedata.Event

class HomeViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<HomeNavigation>>()
    val navigation = _navigation.map { it }

    fun submit() {
        _navigation.value = Event(HomeSubmit)
    }
}
