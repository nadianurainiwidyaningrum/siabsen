package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

data class KegiatanDusun(
    val id: Int,
    val nama: String,
    val tanggal: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KegiatanDusunScreen(
    navController: NavController
) {

    val kegiatanList = listOf(
        KegiatanDusun(
            id = 1,
            nama = "Kerja Bakti Dusun",
            tanggal = "10 September 2026",
            status = "Disetujui"
        ),
        KegiatanDusun(
            id = 2,
            nama = "Pendataan Warga",
            tanggal = "12 September 2026",
            status = "Menunggu"
        ),
        KegiatanDusun(
            id = 3,
            nama = "Musyawarah RT",
            tanggal = "15 September 2026",
            status = "Disetujui"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Kegiatan Dusun",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Screen.TambahKegiatanDusun.route
                    )
                },
                containerColor = PrimaryBlue,
                contentColor = SurfaceLight
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Kegiatan"
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

            Text(
                text = "Daftar Kegiatan Dusun",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = kegiatanList,
                    key = { it.id }
                ) { kegiatan ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    Screen.DetailKegiatanDusun.route
                                )
                            },
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
                                text = kegiatan.nama,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Tanggal : ${kegiatan.tanggal}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Status : ${kegiatan.status}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = when (kegiatan.status) {
                                    "Disetujui" -> com.example.si_absen.ui.theme.SuccessGreen
                                    else -> com.example.si_absen.ui.theme.WarningOrange
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}