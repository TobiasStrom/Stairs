package com.tobiasstrom.stairs.track

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.tobiasstrom.stairs.common.livedata.Event

class TrackViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<TrackNavigation>>()
    val navigation = _navigation.map { it }

    fun startStopTrack(){

    }
}
