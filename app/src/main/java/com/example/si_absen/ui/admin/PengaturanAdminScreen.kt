package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengaturanAdminScreen(
    navController: NavController
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pengaturan Admin",
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
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Row(
                    modifier = Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        shape = CircleShape,
                        color = SurfaceLight
                    ) {

                        Icon(
                            imageVector = Icons.Default.AdminPanelSettings,
                            contentDescription = "Administrator",
                            tint = PrimaryBlue,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(16.dp)
                    )

                    Column {

                        Text(
                            text = "Administrator",
                            color = SurfaceLight,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Kelola sistem SI ABSEN",
                            color = SurfaceLight,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Pengaturan Sistem",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            SettingMenuCard(
                title = "Pengaturan Sistem",
                description = "Konfigurasi aplikasi dan absensi",
                icon = Icons.Default.Settings
            ) {
                navController.navigate(
                    Screen.PengaturanSistem.route
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            SettingMenuCard(
                title = "Manajemen Role",
                description = "Kelola hak akses Admin, Dukuh dan Pegawai",
                icon = Icons.Default.Groups
            ) {
                navController.navigate(
                    Screen.ManajemenRole.route
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            SettingMenuCard(
                title = "Log Aktivitas",
                description = "Riwayat aktivitas pengguna sistem",
                icon = Icons.Default.VerifiedUser
            ) {
                navController.navigate(
                    Screen.LogAktivitas.route
                )
            }
        }
    }
}

@Composable
fun SettingMenuCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = SurfaceLight
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = PrimaryBlue
            )

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Buka $title",
                tint = TextSecondary
            )
        }
    }
}