package com.example.si_absen.auth

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
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@Composable
fun LoginScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "SI ABSEN",
                    style = MaterialTheme.typography.headlineLarge,
                    color = PrimaryBlue
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Sistem Informasi Absensi Pegawai",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Kalurahan Purwobinangun",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                OutlinedTextField(
                    value = nik,
                    onValueChange = {
                        nik = it
                        errorMessage = ""
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
                    modifier = Modifier.height(16.dp)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        errorMessage = ""
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
                    modifier = Modifier.height(24.dp)
                )

                Button(
                    onClick = {

                        errorMessage = ""

                        when {

                            nik == "111" &&
                                    password == "admin" -> {

                                navController.navigate(
                                    Screen.DashboardAdmin.route
                                )
                            }

                            nik == "222" &&
                                    password == "pegawai" -> {

                                navController.navigate(
                                    Screen.DashboardPegawai.route
                                )
                            }

                            nik == "333" &&
                                    password == "dukuh" -> {

                                navController.navigate(
                                    Screen.DashboardDukuh.route
                                )
                            }

                            else -> {
                                errorMessage =
                                    "NIK atau Password salah"
                            }
                        }
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
                        text = "MASUK SISTEM",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                if (errorMessage.isNotEmpty()) {

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = errorMessage,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                TextButton(
                    onClick = {
                        navController.navigate(
                            Screen.ForgotPassword.route
                        )
                    }
                ) {

                    Text(
                        text = "Lupa Password?",
                        style = MaterialTheme.typography.labelLarge,
                        color = PrimaryBlue
                    )
                }
                TextButton(
                    onClick = {
                        navController.navigate(
                            Screen.Register.route
                        )
                    }
                ) {

                    Text(
                        text = "Buat Akun",
                        style = MaterialTheme.typography.labelLarge,
                        color = PrimaryBlue
                    )
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
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