package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPegawaiScreen() {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail Pegawai",
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

            // =========================
            // INFORMASI PEGAWAI
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Nadia Nuraini",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "NIK : 340101",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Jabatan : Sekretaris",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "No HP : 08123456789",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Alamat : Purwobinangun",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    AssistChip(
                        onClick = { },
                        label = {
                            Text(
                                text = "Aktif",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // RIWAYAT ABSENSI
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Riwayat Absensi",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "• 01/09/2026 - Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "• 02/09/2026 - Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "• 03/09/2026 - Terlambat",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "• 04/09/2026 - Hadir",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // =========================
            // TOMBOL AKSI
            // =========================

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryBlue
                    )
                ) {
                    Text(
                        text = "Edit",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Hapus",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}