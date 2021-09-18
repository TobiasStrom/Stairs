package com.tobiasstrom.stairs.common.model

import com.google.firebase.Timestamp
import java.time.LocalDateTime


class TrackedActivity(
    val id: String,
    val userName: String,
    val startFloor: Int,
    val endFloor: Int,
    val startTime: Timestamp,
    val endTime: Timestamp,
    val building : String
    ) {

    fun getTotalFloors(): Int {
        return endFloor - startFloor - 1 // no have floor 0
    }
}