package com.example.si_absen.ui.dummy


import com.example.si_absen.ui.model.User

object DummyUser {

    val users = listOf(

        User(
            id = 1,
            nama = "Admin Kalurahan",
            username = "admin",
            role = "admin"
        ),

        User(
            id = 2,
            nama = "Dukuh Klepu",
            username = "dukuh",
            role = "dukuh"
        ),

        User(
            id = 3,
            nama = "Nadia Nuraini",
            username = "pegawai",
            role = "pegawai"
        )
    )
}