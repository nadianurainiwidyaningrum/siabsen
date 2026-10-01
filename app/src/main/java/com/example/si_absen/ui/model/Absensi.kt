package com.example.si_absen.ui.model


data class Absensi(
    val id: Int,
    val nama: String,
    val tanggal: String,
    val jamMasuk: String,
    val jamPulang: String,
    val status: String
)