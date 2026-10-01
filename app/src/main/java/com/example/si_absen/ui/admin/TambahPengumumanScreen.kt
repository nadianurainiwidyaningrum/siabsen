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
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahPengumumanScreen() {

    var judul by remember { mutableStateOf("") }
    var isi by remember { mutableStateOf("") }
    var tanggalMulai by remember { mutableStateOf("") }
    var tanggalSelesai by remember { mutableStateOf("") }

    var prioritas by remember {
        mutableStateOf("Normal")
    }

    val daftarPrioritas = listOf(
        "Normal",
        "Penting",
        "Sangat Penting"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tambah Pengumuman",
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
                        text = "Publikasi Pengumuman",
                        style = MaterialTheme.typography.titleMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Informasi yang dibuat akan tampil kepada seluruh pegawai dan dukuh.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            OutlinedTextField(
                value = judul,
                onValueChange = {
                    judul = it
                },
                label = {
                    Text(
                        text = "Judul Pengumuman",
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
                value = isi,
                onValueChange = {
                    isi = it
                },
                label = {
                    Text(
                        text = "Isi Pengumuman",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                minLines = 5
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Prioritas",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            daftarPrioritas.forEach { item ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {

                    RadioButton(
                        selected = prioritas == item,
                        onClick = {
                            prioritas = item
                        }
                    )

                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )
            OutlinedTextField(
                value = tanggalMulai,
                onValueChange = {
                    tanggalMulai = it
                },
                label = {
                    Text(
                        text = "Tanggal Mulai",
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
                value = tanggalSelesai,
                onValueChange = {
                    tanggalSelesai = it
                },
                label = {
                    Text(
                        text = "Tanggal Selesai",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

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
                        text = "Preview",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = if (judul.isEmpty())
                            "Belum ada judul"
                        else
                            judul,
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Prioritas : $prioritas",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Mulai : $tanggalMulai",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Selesai : $tanggalSelesai",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    if (isi.isNotBlank()) {
                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = isi,
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
            Button(
                onClick = {
                    // simpan pengumuman
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                )
            ) {
                Text(
                    text = "PUBLIKASIKAN PENGUMUMAN",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )
            OutlinedButton(
                onClick = {
                    // simpan draft
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SIMPAN SEBAGAI DRAFT",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}