package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.ErrorRed
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilAdminScreen() {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profil Admin",
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
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        shape = CircleShape,
                        color = SurfaceLight
                    ) {

                        Icon(
                            imageVector = Icons.Default.AdminPanelSettings,
                            contentDescription = "Administrator",
                            tint = PrimaryBlue,
                            modifier = Modifier
                                .padding(20.dp)
                                .size(48.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "Administrator",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

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
                        text = "Informasi Akun",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "NIP",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "ADM001",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "admin@purwobinangun.id",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Role",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Administrator",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Status",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Text(
                        text = "Aktif",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SuccessGreen
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    // ubah password
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Ubah Password"
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Ubah Password",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedButton(
                onClick = {
                    // logout
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = ErrorRed
                )
            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "Logout"
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Logout",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Versi Aplikasi 1.0.0",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )
        }
    }
}