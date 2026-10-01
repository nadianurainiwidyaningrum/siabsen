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

data class LokasiDummy(
    val nama: String,
    val latitude: String,
    val longitude: String,
    val jarak: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitoringLokasiScreen() {

    var search by remember {
        mutableStateOf("")
    }

    val data = listOf(

        LokasiDummy(
            nama = "Nadia Nuraini",
            latitude = "-7.7562",
            longitude = "110.4011",
            jarak = "25 Meter",
            status = "Dalam Radius"
        ),

        LokasiDummy(
            nama = "Budi Santoso",
            latitude = "-7.7544",
            longitude = "110.4033",
            jarak = "450 Meter",
            status = "Luar Radius"
        ),

        LokasiDummy(
            nama = "Aina Rahmawati",
            latitude = "-7.7571",
            longitude = "110.4020",
            jarak = "15 Meter",
            status = "Dalam Radius"
        )
    )

    val filteredData = data.filter {
        it.nama.contains(
            search,
            ignoreCase = true
        )
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Monitoring Lokasi",
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
            // RINGKASAN LOKASI
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Monitoring GPS Pegawai",
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
                        text = "Lokasi Aktif Hari Ini",
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
                        text = "Cari Nama"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // DAFTAR LOKASI
            // =========================

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = filteredData,
                    key = {
                        "${it.nama}-${it.latitude}-${it.longitude}"
                    }
                ) { item ->

                    val statusColor = when (item.status) {
                        "Dalam Radius" -> SuccessGreen
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
                                text = "Latitude : ${item.latitude}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Longitude : ${item.longitude}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Jarak : ${item.jarak}",
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

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            OutlinedButton(
                                onClick = {
                                    // nanti buka Google Maps
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Lihat Lokasi",
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