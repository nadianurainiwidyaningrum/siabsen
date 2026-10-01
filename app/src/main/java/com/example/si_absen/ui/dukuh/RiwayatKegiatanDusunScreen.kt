package com.example.si_absen.ui.dukuh

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
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary
import com.example.si_absen.ui.theme.WarningOrange

data class RiwayatKegiatan(
    val nama: String,
    val tanggal: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatKegiatanDusunScreen() {

    var search by remember {
        mutableStateOf("")
    }

    val riwayat = listOf(
        RiwayatKegiatan(
            "Kerja Bakti",
            "10 September 2026",
            "Disetujui"
        ),
        RiwayatKegiatan(
            "Pendataan Warga",
            "08 September 2026",
            "Disetujui"
        ),
        RiwayatKegiatan(
            "Musyawarah RT",
            "05 September 2026",
            "Menunggu"
        )
    )

    val filteredList = riwayat.filter {
        it.nama.contains(search, true)
    }

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Riwayat Kegiatan",
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
                        text = "Total Kegiatan",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${riwayat.size}",
                        style = MaterialTheme.typography.headlineLarge,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Kegiatan yang telah diajukan",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
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
                        text = "Cari Kegiatan",
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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = filteredList,
                    key = { "${it.nama}-${it.tanggal}" }
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
                                text = "Tanggal: ${item.tanggal}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            AssistChip(
                                onClick = { },
                                label = {
                                    Text(
                                        text = item.status,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                },
                                colors = AssistChipDefaults.assistChipColors(
                                    containerColor =
                                    if (item.status == "Disetujui") {
                                        SuccessGreen.copy(alpha = 0.12f)
                                    } else {
                                        WarningOrange.copy(alpha = 0.12f)
                                    },
                                    labelColor =
                                    if (item.status == "Disetujui") {
                                        SuccessGreen
                                    } else {
                                        WarningOrange
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}