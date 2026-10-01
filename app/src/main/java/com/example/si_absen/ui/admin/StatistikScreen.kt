package com.example.si_absen.ui.admin

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
import com.example.si_absen.ui.theme.ErrorRed
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary
import com.example.si_absen.ui.theme.WarningOrange

data class StatistikItem(
    val title: String,
    val value: String,
    val color: androidx.compose.ui.graphics.Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatistikScreen() {

    val statistik = listOf(

        StatistikItem(
            title = "Total Pegawai",
            value = "35",
            color = PrimaryBlue
        ),

        StatistikItem(
            title = "Total Dukuh",
            value = "8",
            color = PrimaryBlue
        ),

        StatistikItem(
            title = "Hadir",
            value = "40",
            color = SuccessGreen
        ),

        StatistikItem(
            title = "Terlambat",
            value = "5",
            color = WarningOrange
        ),

        StatistikItem(
            title = "Izin",
            value = "2",
            color = PrimaryBlue
        ),

        StatistikItem(
            title = "Sakit",
            value = "1",
            color = WarningOrange
        ),

        StatistikItem(
            title = "Alpa",
            value = "0",
            color = ErrorRed
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Statistik Kehadiran",
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
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Tingkat Kehadiran",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "93%",
                        style = MaterialTheme.typography.headlineLarge,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Periode September 2026",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = statistik,
                    key = { it.title }
                ) { item ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
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
                                color = item.color
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
                        text = "Kesimpulan",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Mayoritas pegawai dan dukuh hadir tepat waktu. Tingkat kehadiran bulan ini mencapai 93% dengan jumlah keterlambatan yang masih dalam batas normal.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }
        }
    }
}