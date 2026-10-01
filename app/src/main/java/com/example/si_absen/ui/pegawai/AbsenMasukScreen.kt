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
fun AbsenMasukScreen() {

    var keterangan by remember {
        mutableStateOf("")
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Absen Masuk",
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
                        text = "Absensi Masuk Pegawai",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Pastikan Anda berada dalam radius lokasi kantor sebelum melakukan absensi.",
                        color = Color.White
                    )
                }
            }

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
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Foto Selfie"
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

                    Text("Latitude : -7.7612")
                    Text("Longitude : 110.3678")
                    Text("Jarak : 42 Meter")
                    Text("Status : Dalam Radius")
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
                    Text("Keterangan")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

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
                    text = "ABSEN MASUK",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}