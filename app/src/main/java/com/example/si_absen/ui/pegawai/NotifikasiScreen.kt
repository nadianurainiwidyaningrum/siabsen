package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class NotifikasiItem(
    val judul: String,
    val tanggal: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiScreen() {

    val data = listOf(
        NotifikasiItem(
            "Absen Berhasil",
            "10 Sep 2026"
        ),
        NotifikasiItem(
            "Jangan lupa absen pulang",
            "10 Sep 2026"
        ),
        NotifikasiItem(
            "Pengumuman Kalurahan",
            "09 Sep 2026"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notifikasi",
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
                            text = "Pusat Notifikasi",
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
                            text = "Notifikasi Tersedia",
                            color = Color.White
                        )
                    }
                }
            }

            items(data) { item ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null
                        )

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = item.judul,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = item.tanggal,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}