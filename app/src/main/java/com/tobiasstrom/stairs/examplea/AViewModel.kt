package com.tobiasstrom.stairs.examplea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.tobiasstrom.stairs.common.livedata.Event

class AViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<ANavigation>>()
    val navigation = _navigation.map { it }

    fun submit() {
        _navigation.value = Event(ASubmit)
    }
}
