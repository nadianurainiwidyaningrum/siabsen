package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

data class NotifikasiDukuh(
    val judul: String,
    val isi: String,
    val tanggal: String,
    val isRead: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiDukuhScreen() {

    val notifikasi = listOf(

        NotifikasiDukuh(
            judul = "Absensi Berhasil",
            isi = "Absensi masuk berhasil direkam oleh sistem.",
            tanggal = "10 Sep 2026 • 07:35",
            isRead = false
        ),

        NotifikasiDukuh(
            judul = "Kegiatan Disetujui",
            isi = "Pengajuan kegiatan dusun telah disetujui admin.",
            tanggal = "09 Sep 2026 • 15:20",
            isRead = true
        ),

        NotifikasiDukuh(
            judul = "Pengumuman Kalurahan",
            isi = "Terdapat informasi terbaru dari Kalurahan Purwobinangun.",
            tanggal = "08 Sep 2026 • 09:10",
            isRead = true
        )
    )

    Scaffold(
        containerColor = BackgroundLight,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notifikasi",
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
                        text = "Pusat Notifikasi",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${notifikasi.size}",
                        style = MaterialTheme.typography.headlineLarge,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Notifikasi Tersedia",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = notifikasi,
                    key = { "${it.judul}-${it.tanggal}" }
                ) { item ->

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

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .background(
                                        color = if (!item.isRead) {
                                            PrimaryBlue
                                        } else {
                                            BackgroundLight
                                        },
                                        shape = CircleShape
                                    )
                            )

                            Spacer(
                                modifier = Modifier.width(12.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = item.judul,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = item.isi,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )

                                Text(
                                    text = item.tanggal,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary
                                )
                            }
                            if (!item.isRead) {

                                AssistChip(
                                    onClick = { },
                                    label = {
                                        Text(
                                            text = "Baru",
                                            style = MaterialTheme.typography.labelMedium
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}