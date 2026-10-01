package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

data class RiwayatKegiatanPegawai(
    val kegiatan: String,
    val tanggal: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatKegiatanScreen(
    navController: NavController
) {

    val listKegiatan = listOf(

        RiwayatKegiatanPegawai(
            kegiatan = "Rapat Koordinasi",
            tanggal = "10 Sep 2026",
            status = "Valid"
        ),

        RiwayatKegiatanPegawai(
            kegiatan = "Pelayanan Masyarakat",
            tanggal = "08 Sep 2026",
            status = "Valid"
        ),

        RiwayatKegiatanPegawai(
            kegiatan = "Pendataan Warga",
            tanggal = "06 Sep 2026",
            status = "Menunggu Validasi"
        )
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Riwayat Kegiatan",
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
                            text = "Aktivitas Pegawai",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "${listKegiatan.size}",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Kegiatan Tersimpan",
                            color = Color.White
                        )
                    }
                }
            }

            items(listKegiatan) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Screen.DetailKegiatan.route
                            )
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.kegiatan,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Tanggal : ${item.tanggal}"
                        )

                        Text(
                            text = "Status : ${item.status}"
                        )
                    }
                }
            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Informasi",
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Riwayat kegiatan berisi seluruh aktivitas yang telah dilaporkan oleh pegawai dan divalidasi oleh admin."
                        )
                    }
                }
            }
        }
    }
}