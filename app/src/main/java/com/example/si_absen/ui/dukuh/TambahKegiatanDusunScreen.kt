package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKegiatanDusunScreen(
    navController: NavController
) {

    var namaKegiatan by remember {
        mutableStateOf("")
    }

    var tanggal by remember {
        mutableStateOf("14 September 2026")
    }

    var deskripsi by remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = BackgroundLight,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tambah Kegiatan",
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

            OutlinedTextField(
                value = namaKegiatan,
                onValueChange = {
                    namaKegiatan = it
                },
                label = {
                    Text(
                        text = "Nama Kegiatan",
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
                value = tanggal,
                onValueChange = {
                    tanggal = it
                },
                label = {
                    Text(
                        text = "Tanggal Kegiatan",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(12.dp)
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
                        text = "Foto Kegiatan",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .background(
                                BackgroundLight,
                                RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Belum Ada Foto",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )
                    }

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

                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = null
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "AMBIL FOTO",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
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

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = PrimaryBlue
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Lokasi Kegiatan",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Dusun Klepu",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Latitude : -7.7612",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Longitude : 110.3678",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Status : Dalam Radius",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SuccessGreen
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = deskripsi,
                onValueChange = {
                    deskripsi = it
                },
                label = {
                    Text(
                        text = "Deskripsi Kegiatan",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                minLines = 5
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "SIMPAN KEGIATAN",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}