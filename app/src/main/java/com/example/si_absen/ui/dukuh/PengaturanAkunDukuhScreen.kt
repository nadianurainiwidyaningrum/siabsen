package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengaturanAkunDukuhScreen() {

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pengaturan Akun",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Akun Dukuh",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Budi Santoso",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Dusun Klepu",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Keamanan Akun",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(10.dp)
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

                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBlue
                        )
                    ) {
                        Text(
                            text = "Ubah Password",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ubah Nomor HP",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ubah Email",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Informasi Aplikasi",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(10.dp)
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
                        text = "Nama Aplikasi : SI ABSEN",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Versi : 1.0.0",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    // logout
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(
                    text = "Logout",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}