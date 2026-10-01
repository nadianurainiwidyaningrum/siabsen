package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

data class RekapItem(
    val title: String,
    val value: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RekapDusunScreen() {

    val statistik = listOf(
        RekapItem("Hadir", "22"),
        RekapItem("Terlambat", "2"),
        RekapItem("Kegiatan", "15"),
        RekapItem("Izin", "1")
    )

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Rekap Kehadiran",
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
                        text = "Rekap Bulan September 2026",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "92%",
                        style = MaterialTheme.typography.headlineLarge,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Persentase Kehadiran",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Statistik Kehadiran",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(220.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = statistik,
                    key = { it.title }
                ) { item ->

                    Card(
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
                                text = item.title,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = item.value,
                                style = MaterialTheme.typography.headlineMedium,
                                color = PrimaryBlue
                            )
                        }
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
                        text = "Informasi Kehadiran",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Hari Kerja : 24 Hari",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Total Hadir : 22 Hari",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Total Terlambat : 2 Hari",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Total Kegiatan : 15 Kegiatan",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Status : Aktif",
                        style = MaterialTheme.typography.bodyMedium,
                        color = PrimaryBlue
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
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
                        text = "Riwayat Bulan Ini",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "08 Sep 2026 • Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "09 Sep 2026 • Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "10 Sep 2026 • Terlambat",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "11 Sep 2026 • Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}