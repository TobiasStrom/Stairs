package com.tobiasstrom.stairs.stats

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tobiasstrom.stairs.common.api.FirebaseService

class StatsViewModel(private val api: FirebaseService) : ViewModel(){
    init {
        Log.d("Tag", api.getAllActivity().toString())
    }
}
