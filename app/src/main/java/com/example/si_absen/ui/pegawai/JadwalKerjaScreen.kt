package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class JadwalKerja(
    val hari: String,
    val jam: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JadwalKerjaScreen() {

    val jadwal = listOf(
        JadwalKerja("Senin", "07:30 - 16:00"),
        JadwalKerja("Selasa", "07:30 - 16:00"),
        JadwalKerja("Rabu", "07:30 - 16:00"),
        JadwalKerja("Kamis", "07:30 - 16:00"),
        JadwalKerja("Jumat", "07:30 - 11:00")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jadwal Kerja",
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
                            text = "Jadwal Kerja Pegawai",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Kalurahan Purwobinangun",
                            color = Color.White
                        )

                        Text(
                            text = "Jam Kerja Aktif Minggu Ini",
                            color = Color.White
                        )
                    }
                }
            }

            items(jadwal) { item ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                text = item.hari,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Hari Kerja"
                            )
                        }

                        Text(
                            text = item.jam,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            item {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

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
                            text = "Pegawai wajib melakukan absensi masuk dan pulang sesuai jadwal yang telah ditentukan oleh Kalurahan Purwobinangun."
                        )
                    }
                }
            }
        }
    }
}