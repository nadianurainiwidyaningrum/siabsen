package com.example.si_absen.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@Composable
fun RegisterScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var nama by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var konfirmasiPassword by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = SurfaceLight
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Registrasi Pegawai",
                    style = MaterialTheme.typography.headlineMedium,
                    color = PrimaryBlue
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "SI ABSEN Kalurahan Purwobinangun",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                OutlinedTextField(
                    value = nik,
                    onValueChange = {
                        nik = it
                    },
                    label = {
                        Text(
                            text = "NIK",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(
                    value = nama,
                    onValueChange = {
                        nama = it
                    },
                    label = {
                        Text(
                            text = "Nama Lengkap",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(
                            text = "Password",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(
                    value = konfirmasiPassword,
                    onValueChange = {
                        konfirmasiPassword = it
                    },
                    label = {
                        Text(
                            text = "Konfirmasi Password",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Button(
                    onClick = {

                        // sementara dummy
                        navController.popBackStack()

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryBlue
                    )
                ) {

                    Text(
                        text = "DAFTARKAN AKUN",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                TextButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Text(
                        text = "Sudah punya akun? Masuk",
                        style = MaterialTheme.typography.labelLarge,
                        color = PrimaryBlue
                    )
                }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = "© Kalurahan Purwobinangun",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextSecondary
                )
            }
        }
    }
}