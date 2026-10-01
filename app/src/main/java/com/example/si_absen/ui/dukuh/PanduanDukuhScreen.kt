package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanduanDukuhScreen() {

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Panduan Pengguna",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Panduan SI ABSEN",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Panduan penggunaan aplikasi absensi dan kegiatan Dukuh Kalurahan Purwobinangun.",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            PanduanItem(
                nomor = "1",
                judul = "Absen Masuk",
                deskripsi = "Lakukan absensi masuk dengan foto selfie dan lokasi GPS yang valid."
            )

            PanduanItem(
                nomor = "2",
                judul = "Input Kegiatan Dusun",
                deskripsi = "Tambahkan kegiatan yang dilaksanakan di wilayah dusun beserta dokumentasi foto."
            )

            PanduanItem(
                nomor = "3",
                judul = "Absen Pulang",
                deskripsi = "Lakukan absensi pulang setelah seluruh aktivitas selesai."
            )

            PanduanItem(
                nomor = "4",
                judul = "Cek Riwayat Kegiatan",
                deskripsi = "Lihat seluruh kegiatan yang pernah diajukan dan status validasinya."
            )

            PanduanItem(
                nomor = "5",
                judul = "Lihat Rekap Kehadiran",
                deskripsi = "Pantau data kehadiran bulanan dan statistik absensi."
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SurfaceLight
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Bantuan",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Admin Sistem SI ABSEN",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Email : admin@purwobinangun.id",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )

                    Text(
                        text = "Telepon : (0274) 123456",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}

@Composable
fun PanduanItem(
    nomor: String,
    judul: String,
    deskripsi: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = SurfaceLight
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Langkah $nomor",
                style = MaterialTheme.typography.labelLarge,
                color = PrimaryBlue
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = judul,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = deskripsi,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )
        }
    }
}