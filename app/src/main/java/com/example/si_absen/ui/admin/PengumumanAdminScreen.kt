package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.WarningOrange

data class PengumumanItem(
    val id: Int,
    val judul: String,
    val tanggal: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengumumanAdminScreen(
    navController: NavController
) {

    var search by remember {
        mutableStateOf("")
    }

    val pengumumanList = listOf(

        PengumumanItem(
            id = 1,
            judul = "Rapat Kalurahan",
            tanggal = "15 September 2026",
            status = "Aktif"
        ),

        PengumumanItem(
            id = 2,
            judul = "Kerja Bakti Lingkungan",
            tanggal = "20 September 2026",
            status = "Aktif"
        ),

        PengumumanItem(
            id = 3,
            judul = "Pelatihan Sistem Absensi",
            tanggal = "25 September 2026",
            status = "Draft"
        )
    )

    val filteredList = pengumumanList.filter {
        it.judul.contains(search, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pengumuman",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Screen.TambahPengumuman.route
                    )
                },
                containerColor = PrimaryBlue,
                contentColor = SurfaceLight
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Pengumuman"
                )
            }
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
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Total Pengumuman",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${pengumumanList.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Pengumuman Aktif dan Draft",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            OutlinedTextField(
                value = search,
                onValueChange = {
                    search = it
                },
                label = {
                    Text(
                        text = "Cari Pengumuman",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = filteredList,
                    key = { it.id }
                ) { item ->

                    val statusColor = when (item.status) {
                        "Aktif" -> SuccessGreen
                        else -> WarningOrange
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { },
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
                                text = item.judul,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Tanggal : ${item.tanggal}",
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
                                    // detail pengumuman
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Lihat Detail",
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