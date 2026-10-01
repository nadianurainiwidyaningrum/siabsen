package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RekapKehadiranScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Rekap Kehadiran",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1565C0)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Ringkasan Kehadiran",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "92%",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Persentase Kehadiran",
                            color = Color.White
                        )
                    }
                }
            }

            item {
                StatistikCard(
                    title = "Total Hadir",
                    value = "22 Hari"
                )
            }

            item {
                StatistikCard(
                    title = "Terlambat",
                    value = "2 Hari"
                )
            }

            item {
                StatistikCard(
                    title = "Izin",
                    value = "1 Hari"
                )
            }

            item {
                StatistikCard(
                    title = "Sakit",
                    value = "0 Hari"
                )
            }

            item {
                StatistikCard(
                    title = "Alpa",
                    value = "0 Hari"
                )
            }

            item {
                StatistikCard(
                    title = "Persentase Kehadiran",
                    value = "92%"
                )
            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Keterangan",
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Data rekap kehadiran dihitung berdasarkan absensi masuk, absensi pulang, dan validasi kegiatan selama periode berjalan."
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatistikCard(
    title: String,
    value: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}