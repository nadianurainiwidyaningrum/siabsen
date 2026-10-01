package com.example.si_absen.ui.utils

object LocationUtils {

    fun isInsideRadius(
        distance: Float,
        radius: Int = Constants.ABSEN_RADIUS
    ): Boolean {

        return distance <= radius
    }
}