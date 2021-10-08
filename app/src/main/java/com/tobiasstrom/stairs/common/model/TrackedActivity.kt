package com.tobiasstrom.stairs.common.model

import com.google.firebase.Timestamp
import java.time.LocalDateTime


class TrackedActivity(
    val id: String? = null,
    val userName: String? = null,
    val startFloor: Int? = null,
    val endFloor: Int? = null,
    val startTime: Timestamp? = null,
    val endTime: Timestamp? = null,
    val building : String? = null
    ) {

    fun getTotalFloors(): Int {
        return endFloor!! - startFloor!! - 1 // no have floor 0
    }
}