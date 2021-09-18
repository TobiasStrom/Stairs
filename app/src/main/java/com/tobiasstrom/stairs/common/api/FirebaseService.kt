package com.tobiasstrom.stairs.common.api

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.tobiasstrom.stairs.common.Constants
import com.tobiasstrom.stairs.common.model.TrackedActivity



class FirebaseService() {
    val database = Firebase.firestore
    val activitiesDB = database.collection(Constants.ACTIVITY_DB_NAME)

    fun getMessages(){

    }
    fun setMessages(message: String){

        val mes = hashMapOf(
            "message" to message
        )
        database.collection("messages")
            .add(mes)
    }

    fun saveActivity(activity: TrackedActivity){
        database.collection(Constants.ACTIVITY_DB_NAME)
            .add(activity)
    }

    fun getAllActivity(): List<TrackedActivity>{
        val activitiesList: MutableList<TrackedActivity> = mutableListOf()
        activitiesDB.get().addOnSuccessListener  { activities ->
            for (activity in activities){
                activitiesList.add(activity.toObject<TrackedActivity>())
            }
        }
        return  activitiesList
    }
}