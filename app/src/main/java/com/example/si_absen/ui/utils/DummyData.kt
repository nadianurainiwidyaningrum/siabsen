package com.example.si_absen.ui.utils

import com.example.si_absen.ui.model.User

object DummyData {

    val adminUser = User(
        id = 1,
        nama = "Administrator",
        username = "admin",
        role = Constants.ROLE_ADMIN
    )

    val dukuhUser = User(
        id = 2,
        nama = "Budi Santoso",
        username = "dukuh",
        role = Constants.ROLE_DUKUH
    )

    val pegawaiUser = User(
        id = 3,
        nama = "Nadia Nuraini",
        username = "pegawai",
        role = Constants.ROLE_PEGAWAI
    )

    val allUsers = listOf(
        adminUser,
        dukuhUser,
        pegawaiUser
    )
}