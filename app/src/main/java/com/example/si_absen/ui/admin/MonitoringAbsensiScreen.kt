package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.ErrorRed
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.WarningOrange

data class AbsensiDummy(
    val nama: String,
    val role: String,
    val tanggal: String,
    val jamMasuk: String,
    val jamPulang: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitoringAbsensiScreen() {

    var search by remember {
        mutableStateOf("")
    }

    val data = listOf(

        AbsensiDummy(
            nama = "Nadia Nuraini",
            role = "Pegawai",
            tanggal = "11-09-2026",
            jamMasuk = "07:30",
            jamPulang = "16:00",
            status = "Hadir"
        ),

        AbsensiDummy(
            nama = "Budi Santoso",
            role = "Dukuh",
            tanggal = "11-09-2026",
            jamMasuk = "07:45",
            jamPulang = "16:10",
            status = "Terlambat"
        ),

        AbsensiDummy(
            nama = "Aina Rahmawati",
            role = "Pegawai",
            tanggal = "11-09-2026",
            jamMasuk = "-",
            jamPulang = "-",
            status = "Belum Hadir"
        )
    )

    val filteredData = data.filter {
        it.nama.contains(search, ignoreCase = true)
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Monitoring Absensi",
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

            // =========================
            // RINGKASAN HARI INI
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Ringkasan Hari Ini",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${data.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Total Data Absensi",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // PENCARIAN
            // =========================

            OutlinedTextField(
                value = search,
                onValueChange = {
                    search = it
                },
                label = {
                    Text(
                        text = "Cari Pegawai / Dukuh"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // DATA ABSENSI
            // =========================

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = filteredData,
                    key = {
                        "${it.nama}-${it.tanggal}"
                    }
                ) { item ->

                    val statusColor = when (item.status) {
                        "Hadir" -> SuccessGreen
                        "Terlambat" -> WarningOrange
                        else -> ErrorRed
                    }

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
                                text = item.nama,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Role : ${item.role}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Tanggal : ${item.tanggal}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Jam Masuk : ${item.jamMasuk}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Jam Pulang : ${item.jamPulang}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            AssistChip(
                                onClick = { },
                                label = {
                                    Text(
                                        text = item.status,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                },
                                colors = AssistChipDefaults.assistChipColors(
                                    containerColor = statusColor.copy(
                                        alpha = 0.15f
                                    ),
                                    labelColor = statusColor
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}