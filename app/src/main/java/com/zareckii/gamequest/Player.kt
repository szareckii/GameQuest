package com.zareckii.gamequest

class Player(
    private val id: Int,
    private val status: Status,

    private val name: String,

) {
    fun getId() = id

    fun getName() = name

    fun getStatus() = status

    enum class Status {
        LOCATION1,
        LOCATION2,
        LOCATION3,
        LOCATION4
    }
}