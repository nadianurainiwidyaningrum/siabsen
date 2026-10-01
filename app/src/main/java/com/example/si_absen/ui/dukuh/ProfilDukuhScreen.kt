package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilDukuhScreen() {

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profil Dukuh",
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        modifier = Modifier.size(90.dp),
                        shape = CircleShape,
                        color = SurfaceLight
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "BS",
                                style = MaterialTheme.typography.headlineMedium,
                                color = PrimaryBlue
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Budi Santoso",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Dukuh Dusun Klepu",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Informasi Pribadi",
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
                        text = "NIK",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "340101",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Nomor HP",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "081234567890",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Jabatan",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Dukuh",
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Wilayah Kerja",
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
                        text = "Dusun",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Klepu",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Kalurahan",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Purwobinangun",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Status",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Aktif",
                        style = MaterialTheme.typography.titleSmall,
                        color = SuccessGreen
                    )
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    // edit profil
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                )
            ) {
                Text(
                    text = "Edit Profil",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}