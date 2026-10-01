package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary
import com.example.si_absen.ui.theme.WarningOrange

data class ValidasiDummy(
    val nama: String,
    val kegiatan: String,
    val lokasi: String,
    val waktu: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValidasiAbsensiScreen() {

    val data = listOf(

        ValidasiDummy(
            nama = "Budi Santoso",
            kegiatan = "Kerja Bakti",
            lokasi = "Dusun Klepu",
            waktu = "08:00 WIB",
            status = "Menunggu"
        ),

        ValidasiDummy(
            nama = "Slamet Riyadi",
            kegiatan = "Pendataan Warga",
            lokasi = "Dusun Ngebel",
            waktu = "09:15 WIB",
            status = "Menunggu"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Validasi Absensi",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundLight)
                .padding(padding)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Pengajuan Menunggu Validasi",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "${data.size}",
                        style = MaterialTheme.typography.headlineLarge,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Absensi Kegiatan",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            data.forEach { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = SurfaceLight
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = item.nama,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = item.status,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = WarningOrange
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )
                        Text(
                            text = "Kegiatan : ${item.kegiatan}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "Lokasi : ${item.lokasi}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "Waktu : ${item.waktu}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = BackgroundLight
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "Foto Bukti Kegiatan",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = TextSecondary
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Button(
                                onClick = { },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = SuccessGreen
                                )
                            ) {
                                Text(
                                    text = "Setujui",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }

                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Tolak",
                                    style = MaterialTheme.typography.labelLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}