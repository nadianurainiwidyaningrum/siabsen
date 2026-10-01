package com.example.si_absen.ui.model


data class Laporan(
    val id: Int,
    val nama: String,
    val hadir: Int,
    val izin: Int,
    val sakit: Int
)