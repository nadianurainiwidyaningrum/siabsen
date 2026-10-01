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
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

data class RoleItem(
    val namaRole: String,
    val jumlahUser: String,
    val deskripsi: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManajemenRoleScreen() {

    val roleList = listOf(

        RoleItem(
            namaRole = "Admin",
            jumlahUser = "1 User",
            deskripsi = "Mengelola seluruh sistem aplikasi"
        ),

        RoleItem(
            namaRole = "Pegawai",
            jumlahUser = "35 User",
            deskripsi = "Melakukan absensi dan kegiatan harian"
        ),

        RoleItem(
            namaRole = "Dukuh",
            jumlahUser = "8 User",
            deskripsi = "Mengelola wilayah dan kegiatan dusun"
        )
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Manajemen Role",
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
                        text = "Total Role Sistem",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "${roleList.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            roleList.forEach { role ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 3.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = SurfaceLight
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = role.namaRole,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = role.jumlahUser,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = role.deskripsi,
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Button(
                            onClick = { },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryBlue
                            )
                        ) {
                            Text(
                                text = "Kelola Role",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }
        }
    }
}