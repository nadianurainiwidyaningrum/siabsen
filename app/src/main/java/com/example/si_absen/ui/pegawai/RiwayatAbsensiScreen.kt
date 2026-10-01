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

data class AbsensiItem(
    val tanggal: String,
    val masuk: String,
    val pulang: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatAbsensiScreen(
    navController: NavController
) {

    val data = listOf(
        AbsensiItem(
            tanggal = "10 Sep 2026",
            masuk = "07:28",
            pulang = "16:03",
            status = "Hadir"
        ),
        AbsensiItem(
            tanggal = "09 Sep 2026",
            masuk = "07:35",
            pulang = "16:00",
            status = "Terlambat"
        ),
        AbsensiItem(
            tanggal = "08 Sep 2026",
            masuk = "07:29",
            pulang = "16:05",
            status = "Hadir"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Riwayat Absensi",
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
                            text = "Riwayat Absensi",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "${data.size}",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Data Absensi Tersimpan",
                            color = Color.White
                        )
                    }
                }
            }

            items(data) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Screen.DetailAbsensi.route
                            )
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.tanggal,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text("Jam Masuk : ${item.masuk}")
                        Text("Jam Pulang : ${item.pulang}")
                        Text("Status : ${item.status}")
                    }
                }
            }
        }
    }
}