package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MonitoringWilayahScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Monitoring Wilayah",
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
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Wilayah Tugas",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Dusun Klepu",
                        style = MaterialTheme.typography.headlineSmall,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Statistik Bulan Ini",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Card(
                    modifier = Modifier.weight(1f),
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
                            text = "Kegiatan",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "12",
                            style = MaterialTheme.typography.headlineMedium,
                            color = PrimaryBlue
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f),
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
                            text = "Absensi",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "24",
                            style = MaterialTheme.typography.headlineMedium,
                            color = PrimaryBlue
                        )
                    }
                }
            }

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
                        text = "Status Kehadiran",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    LinearProgressIndicator(
                        progress = { 0.92f },
                        modifier = Modifier.fillMaxWidth(),
                        color = PrimaryBlue
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "92% Kehadiran Bulan Ini",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }

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
                        text = "Ringkasan Wilayah",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "• Total kegiatan terlaksana : 12",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "• Kegiatan menunggu validasi : 2",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "• Absensi berhasil : 24",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "• Tidak ada pelanggaran lokasi",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}