package com.example.si_absen.ui.dummy


import com.example.si_absen.ui.model.Kegiatan

object DummyKegiatan {

    val kegiatanList = listOf(

        Kegiatan(
            id = 1,
            nama = "Rapat Koordinasi",
            tanggal = "10-09-2026",
            lokasi = "Kalurahan",
            status = "Valid"
        ),

        Kegiatan(
            id = 2,
            nama = "Kerja Bakti Dusun",
            tanggal = "09-09-2026",
            lokasi = "Dusun Klepu",
            status = "Valid"
        )
    )
}