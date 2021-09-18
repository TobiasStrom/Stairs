package com.tobiasstrom.stairs.track

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.google.firebase.Timestamp
import com.google.type.Date
import com.google.type.DateTime
import com.tobiasstrom.stairs.R
import com.tobiasstrom.stairs.common.api.FirebaseService
import com.tobiasstrom.stairs.common.livedata.Event
import com.tobiasstrom.stairs.common.model.TrackedActivity
import java.time.LocalDateTime
import java.util.*
import kotlin.random.Random

class TrackViewModel(private val api: FirebaseService) : ViewModel() {

    private val _navigation = MutableLiveData<Event<TrackNavigation>>()
    val navigation = _navigation.map { it }

    val started: Boolean = false

    var buttonColor: Int = if (started) R.color.button_red else R.color.button_green

    fun getField(){
        val floors = getFloors()
        val activity = TrackedActivity(
            id = UUID.randomUUID().toString(),
            userName = "Tobias",
            startFloor = floors.first,
            endFloor = floors.last,
            startTime = Timestamp(Date()),
            endTime = Timestamp(Date()),
            building = "Rebel"
        )
        saveTrack(activity)

    }

    private fun getFloors(): Floors{

        val first = Random.nextInt(-10, 10)
        var last = -10
        var startIsBellowEnd: Boolean = false
        while (!startIsBellowEnd){
            last = Random.nextInt(-9, 50)
            if(last > first){
                startIsBellowEnd = true
            }
        }
        return Floors(first, last)
    }

    private fun saveTrack(act: TrackedActivity){
      api.saveActivity(act)
    }


}

data class Floors(var first: Int, var last: Int)