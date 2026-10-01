package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profil Pegawai",
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
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        shape = CircleShape,
                        color = Color.White,
                        modifier = Modifier.size(80.dp)
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp),
                                tint = Color(0xFF1565C0)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Nadia Nuraini",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Staff Administrasi",
                        color = Color.White
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Informasi Pegawai",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text("NIK : 340101")
                    Text("Nama : Nadia Nuraini")
                    Text("Jabatan : Staff Administrasi")
                    Text("No HP : 081234567890")
                    Text("Unit Kerja : Kalurahan Purwobinangun")
                    Text("Status : Aktif")
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = {
                    navController.navigate(
                        Screen.EditProfil.route
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text("EDIT PROFIL")
            }
        }
    }
}