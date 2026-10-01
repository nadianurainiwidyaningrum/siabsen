package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
@Composable
fun DashboardPegawaiScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dashboard Pegawai",
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
                        text = "Selamat Datang",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Nadia Nuraini",
                        color = Color.White
                    )

                    Text(
                        text = "Staff Administrasi",
                        color = Color.White
                    )

                    Text(
                        text = "Status Hari Ini : Belum Absen",
                        color = Color.White
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
                    modifier = Modifier.weight(1f)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text("Hadir")

                        Text(
                            text = "22",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Card(
                    modifier = Modifier.weight(1f)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text("Terlambat")

                        Text(
                            text = "2",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Menu Utama",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                MenuPegawaiCard("Absen Masuk") {
                    navController.navigate(Screen.AbsenMasuk.route)
                }

                MenuPegawaiCard("Absen Pulang") {
                    navController.navigate(Screen.AbsenPulang.route)
                }

                MenuPegawaiCard("Absen Kegiatan") {
                    navController.navigate(Screen.AbsenKegiatan.route)
                }

                MenuPegawaiCard("Jadwal Kerja") {
                    navController.navigate(Screen.JadwalKerja.route)
                }

                MenuPegawaiCard("Riwayat Absensi") {
                    navController.navigate(Screen.RiwayatAbsensi.route)
                }

                MenuPegawaiCard("Rekap Kehadiran") {
                    navController.navigate(Screen.RekapKehadiran.route)
                }

                MenuPegawaiCard("Notifikasi") {
                    navController.navigate(Screen.Notifikasi.route)
                }

                MenuPegawaiCard("Profil") {
                    navController.navigate(Screen.Profil.route)
                }

                MenuPegawaiCard("Pengaturan") {
                    navController.navigate(Screen.PengaturanAkun.route)
                }

                MenuPegawaiCard("Panduan") {
                    navController.navigate(Screen.Panduan.route)
                }

                MenuPegawaiCard("Tentang") {
                    navController.navigate(Screen.Tentang.route)
                }
            }
        }
    }
}

@Composable
fun MenuPegawaiCard(
    title: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .width(160.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                fontWeight = FontWeight.Medium
            )
        }
    }
}