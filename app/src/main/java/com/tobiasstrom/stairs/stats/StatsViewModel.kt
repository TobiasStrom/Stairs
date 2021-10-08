package com.tobiasstrom.stairs.stats

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tobiasstrom.stairs.common.api.FirebaseService

class StatsViewModel(private val api: FirebaseService) : ViewModel(){
    init {
        val list = api.getAllActivity()
        for (item in list){
            item.id?.let { Log.d("Tag", it) }
        }

    }
}
