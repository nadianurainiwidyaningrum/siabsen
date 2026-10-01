package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

data class LogAktivitas(
    val aktivitas: String,
    val pengguna: String,
    val waktu: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogAktivitasScreen() {

    val logList = listOf(
        LogAktivitas(
            aktivitas = "Menambah Pegawai",
            pengguna = "Admin",
            waktu = "11 Sep 2026 08:00"
        ),
        LogAktivitas(
            aktivitas = "Mengubah Pengumuman",
            pengguna = "Admin",
            waktu = "11 Sep 2026 09:15"
        ),
        LogAktivitas(
            aktivitas = "Validasi Absensi",
            pengguna = "Admin",
            waktu = "11 Sep 2026 10:20"
        ),
        LogAktivitas(
            aktivitas = "Export Laporan PDF",
            pengguna = "Admin",
            waktu = "11 Sep 2026 11:30"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Log Aktivitas",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundLight)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            // =========================
            // RINGKASAN AKTIVITAS
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Total Aktivitas Hari Ini",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${logList.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // DAFTAR AKTIVITAS
            // =========================

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = logList,
                    key = { "${it.aktivitas}-${it.waktu}" }
                ) { log ->

                    LogAktivitasCard(
                        log = log
                    )
                }
            }
        }
    }
}

@Composable
private fun LogAktivitasCard(
    log: LogAktivitas
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = SurfaceLight
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = log.aktivitas,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Pengguna : ${log.pengguna}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = log.waktu,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}