package com.tobiasstrom.stairs.common.service

interface RemoteConfig {

    suspend fun init(): RemoteConfig

    fun isVersionLocked(): Boolean
}
