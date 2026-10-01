package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengaturanSistemScreen() {

    var radius by remember { mutableStateOf("100") }
    var jamMasuk by remember { mutableStateOf("07:30") }
    var jamPulang by remember { mutableStateOf("16:00") }
    var toleransi by remember { mutableStateOf("15") }

    var gpsAktif by remember { mutableStateOf(true) }
    var fotoAktif by remember { mutableStateOf(true) }
    var notifikasiAktif by remember { mutableStateOf(true) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pengaturan Sistem",
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
                        text = "Konfigurasi Sistem SI ABSEN",
                        style = MaterialTheme.typography.titleMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Kelola aturan absensi, GPS, dan jam kerja pegawai.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Pengaturan Absensi",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = radius,
                onValueChange = { radius = it },
                label = {
                    Text(
                        text = "Radius Absensi (Meter)",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = toleransi,
                onValueChange = { toleransi = it },
                label = {
                    Text(
                        text = "Toleransi Keterlambatan (Menit)",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Jam Kerja",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = jamMasuk,
                onValueChange = { jamMasuk = it },
                label = {
                    Text(
                        text = "Jam Masuk",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = jamPulang,
                onValueChange = { jamPulang = it },
                label = {
                    Text(
                        text = "Jam Pulang",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Fitur Sistem",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = SurfaceLight
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Aktifkan GPS",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Switch(
                            checked = gpsAktif,
                            onCheckedChange = {
                                gpsAktif = it
                            }
                        )
                    }

                    HorizontalDivider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Wajib Foto Selfie",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Switch(
                            checked = fotoAktif,
                            onCheckedChange = {
                                fotoAktif = it
                            }
                        )
                    }

                    HorizontalDivider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Notifikasi Absensi",
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Switch(
                            checked = notifikasiAktif,
                            onCheckedChange = {
                                notifikasiAktif = it
                            }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
            Button(
                onClick = {
                    // simpan pengaturan
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                )
            ) {
                Text(
                    text = "Simpan Pengaturan",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}