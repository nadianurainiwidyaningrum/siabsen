package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

data class MenuDukuh(
    val title: String,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardDukuhScreen(
    navController: NavController
) {

    val menuList = listOf(

        MenuDukuh(
            "Absen Masuk",
            Screen.AbsenMasukDukuh.route
        ),

        MenuDukuh(
            "Absen Pulang",
            Screen.AbsenPulangDukuh.route
        ),

        MenuDukuh(
            "Kegiatan Dusun",
            Screen.KegiatanDusun.route
        ),

        MenuDukuh(
            "Riwayat Kegiatan",
            Screen.RiwayatKegiatanDusun.route
        ),

        MenuDukuh(
            "Monitoring Wilayah",
            Screen.MonitoringWilayah.route
        ),

        MenuDukuh(
            "Rekap Kehadiran",
            Screen.RekapDusun.route
        ),

        MenuDukuh(
            "Notifikasi",
            Screen.NotifikasiDukuh.route
        ),

        MenuDukuh(
            "Profil",
            Screen.ProfilDukuh.route
        ),

        MenuDukuh(
            "Pengaturan",
            Screen.PengaturanAkunDukuh.route
        ),

        MenuDukuh(
            "Panduan",
            Screen.PanduanDukuh.route
        ),

        MenuDukuh(
            "Tentang",
            Screen.TentangDukuh.route
        )
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dashboard Dukuh",
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
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Selamat Datang",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Budi Santoso",
                        style = MaterialTheme.typography.headlineSmall,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Dukuh Dusun Klepu",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "Status Hari Ini : Belum Absen",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Card(
                    modifier = Modifier.weight(1f),
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
                            text = "Kegiatan",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "12",
                            style = MaterialTheme.typography.headlineMedium,
                            color = PrimaryBlue
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f),
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
                            text = "Hadir",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "24",
                            style = MaterialTheme.typography.headlineMedium,
                            color = PrimaryBlue
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Menu Utama",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = menuList,
                    key = { it.route }
                ) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clickable {
                                navController.navigate(
                                    item.route
                                )
                            },
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SurfaceLight
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {

                            Text(
                                text = item.title,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }
        }
    }
}