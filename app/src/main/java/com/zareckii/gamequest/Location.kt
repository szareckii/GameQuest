package com.zareckii.gamequest

import android.util.Log

interface TaskProgressCallback {
    fun updatePlayer(player: Player)
}

abstract class Location(
    private val callback: TaskProgressCallback,
    private val name: String,
    private val playerStatus: Player.Status
) : PlayerHandler {

    override fun doStep(player: Player): Boolean {
        val canHandle = playerStatus == player.getStatus()
        if (canHandle) {
            Log.e("stas", javaClass.simpleName + " " + name + "is doing task " + getDetails(player))
            callback.updatePlayer(getPlayerWhenDone(player))
        }
        return canHandle
    }

    abstract fun getPlayerWhenDone(player: Player): Player

    protected abstract fun getDetails(player: Player): String
}