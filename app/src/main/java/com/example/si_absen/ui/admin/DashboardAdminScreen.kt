package com.example.si_absen.ui.screen.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

data class AdminMenu(
    val title: String,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardAdminScreen(
    navController: NavController
) {

    val menuList = listOf(

        AdminMenu(
            title = "Data Pegawai",
            route = Screen.DataPegawai.route
        ),

        AdminMenu(
            title = "Data Dukuh",
            route = Screen.DataDukuh.route
        ),

        AdminMenu(
            title = "Monitoring Absensi",
            route = Screen.MonitoringAbsensi.route
        ),

        AdminMenu(
            title = "Monitoring Lokasi",
            route = Screen.MonitoringLokasi.route
        ),

        AdminMenu(
            title = "Validasi Absensi",
            route = Screen.ValidasiAbsensi.route
        ),

        AdminMenu(
            title = "Statistik",
            route = Screen.Statistik.route
        ),

        AdminMenu(
            title = "Laporan",
            route = Screen.Laporan.route
        ),

        AdminMenu(
            title = "Pengumuman",
            route = Screen.PengumumanAdmin.route
        ),

        AdminMenu(
            title = "Pengaturan",
            route = Screen.PengaturanAdmin.route
        ),

        AdminMenu(
            title = "Profil",
            route = Screen.ProfilAdmin.route
        )
    )

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Column {

                        Text(
                            text = "Dashboard Admin",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Kalurahan Purwobinangun",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BackgroundLight)
                .padding(16.dp)

        ) {

            // ==============================
            // RINGKASAN HARI INI
            // ==============================

            Text(
                text = "Ringkasan Hari Ini",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StatistikCard(
                    title = "Pegawai",
                    value = "35",
                    modifier = Modifier.weight(1f)
                )

                StatistikCard(
                    title = "Dukuh",
                    value = "8",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                StatistikCard(
                    title = "Hadir",
                    value = "40",
                    modifier = Modifier.weight(1f)
                )

                StatistikCard(
                    title = "Belum Hadir",
                    value = "3",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // ==============================
            // MENU ADMIN
            // ==============================

            Text(
                text = "Menu Admin",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyVerticalGrid(

                columns = GridCells.Fixed(2),

                verticalArrangement = Arrangement.spacedBy(12.dp),

                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(menuList) { menu ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .clickable {

                                navController.navigate(
                                    menu.route
                                )
                            },

                        shape = RoundedCornerShape(16.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = SurfaceLight
                        ),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                        Box(

                            modifier = Modifier.fillMaxSize(),

                            contentAlignment = Alignment.Center

                        ) {

                            Text(
                                text = menu.title,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }
        }
    }
}

// ======================================================
// STATISTIK CARD
// ======================================================

@Composable
fun StatistikCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {

    Card(

        modifier = modifier,

        colors = CardDefaults.cardColors(
            containerColor = PrimaryBlue
        ),

        shape = RoundedCornerShape(16.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text(
                text = title,
                color = SurfaceLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = value,
                color = SurfaceLight,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}