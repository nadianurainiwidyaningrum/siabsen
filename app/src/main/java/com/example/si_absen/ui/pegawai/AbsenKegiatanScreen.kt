package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsenKegiatanScreen() {

    var namaKegiatan by remember { mutableStateOf("") }
    var keterangan by remember { mutableStateOf("") }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Absen Kegiatan",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(16.dp)
        ) {

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
                        text = "Absensi Kegiatan Pegawai",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Lengkapi data kegiatan dan unggah foto sebagai bukti aktivitas.",
                        color = Color.White
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            OutlinedTextField(
                value = namaKegiatan,
                onValueChange = {
                    namaKegiatan = it
                },
                label = {
                    Text("Nama Kegiatan")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Foto Kegiatan"
                    )

                    Text(
                        text = "Belum ada foto yang dipilih"
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Button(
                        onClick = { }
                    ) {
                        Text("AMBIL FOTO")
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            OutlinedTextField(
                value = keterangan,
                onValueChange = {
                    keterangan = it
                },
                label = {
                    Text("Keterangan Kegiatan")
                },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4,
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Informasi Lokasi",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text("Lokasi : Kantor Kalurahan Purwobinangun")
                    Text("Latitude : -7.7612")
                    Text("Longitude : 110.3678")
                    Text("Status : Dalam Radius")
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {

                Text(
                    text = "SIMPAN KEGIATAN",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}