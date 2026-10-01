package com.example.si_absen.ui.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {

    private val indonesiaLocale = Locale("id", "ID")

    fun getCurrentDate(): String {
        return SimpleDateFormat(
            "dd MMMM yyyy",
            indonesiaLocale
        ).format(Date())
    }

    fun getCurrentTime(): String {
        return SimpleDateFormat(
            "HH:mm",
            indonesiaLocale
        ).format(Date())
    }

    fun getCurrentDateTime(): String {
        return SimpleDateFormat(
            "dd MMMM yyyy HH:mm",
            indonesiaLocale
        ).format(Date())
    }

    fun getCurrentDay(): String {
        return SimpleDateFormat(
            "EEEE",
            indonesiaLocale
        ).format(Date())
    }

    fun getCurrentDayAndDate(): String {
        return SimpleDateFormat(
            "EEEE, dd MMMM yyyy",
            indonesiaLocale
        ).format(Date())
    }
}