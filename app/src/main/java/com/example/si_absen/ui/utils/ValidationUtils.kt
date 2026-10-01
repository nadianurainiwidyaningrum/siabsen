package com.example.si_absen.ui.utils

object ValidationUtils {

    fun isLoginValid(
        username: String,
        password: String
    ): Boolean {

        return username.isNotBlank()
                && password.isNotBlank()
    }

    fun isRegisterValid(
        nama: String,
        username: String,
        password: String
    ): Boolean {

        return nama.isNotBlank()
                && username.isNotBlank()
                && password.length >= 6
    }
}