package com.example.si_absen.ui.dummy

import com.example.si_absen.ui.model.Absensi

object DummyAbsensi {

    val listAbsensi = listOf(

        Absensi(
            id = 1,
            nama = "Nadia Nuraini",
            tanggal = "11-09-2026",
            jamMasuk = "07:30",
            jamPulang = "16:00",
            status = "Hadir"
        ),

        Absensi(
            id = 2,
            nama = "Aina Rahmawati",
            tanggal = "11-09-2026",
            jamMasuk = "07:25",
            jamPulang = "16:05",
            status = "Hadir"
        )
    )
}