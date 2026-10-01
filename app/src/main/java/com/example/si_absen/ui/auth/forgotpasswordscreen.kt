package com.example.si_absen.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.ErrorRed
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.SurfaceLight
import com.example.si_absen.ui.theme.TextSecondary

@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var pesan by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    var isSuccess by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Kembali",
                        tint = PrimaryBlue
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Icon(
                imageVector = Icons.Default.LockReset,
                contentDescription = "Reset Password",
                tint = PrimaryBlue,
                modifier = Modifier.size(64.dp)
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Lupa Password?",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Reset password akun SI ABSEN",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SurfaceLight
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Masukkan NIK Anda",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Kami akan mengirimkan kode verifikasi atau tautan reset password ke email yang terdaftar pada akun Anda.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    OutlinedTextField(
                        value = nik,
                        onValueChange = {
                            nik = it
                            pesan = ""
                            isSuccess = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = "NIK Pegawai",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Masukkan NIK",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )
                    Button(
                        onClick = {

                            if (nik.isBlank()) {

                                pesan = "NIK wajib diisi"
                                isSuccess = false

                            } else {

                                isLoading = true

                                /*
                                 * TODO:
                                 * Panggil API reset password.
                                 *
                                 * Backend:
                                 * 1. Mencari akun berdasarkan NIK
                                 * 2. Mengambil email pegawai
                                 * 3. Membuat OTP / token
                                 * 4. Mengirim email
                                 * 5. Mengembalikan response
                                 *
                                 * Untuk sementara menggunakan dummy response.
                                 */

                                isLoading = false

                                pesan =
                                    "Kode verifikasi telah dikirim ke email yang terdaftar pada akun Anda."

                                isSuccess = true
                            }
                        },
                        enabled = !isLoading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBlue
                        )
                    ) {

                        if (isLoading) {

                            CircularProgressIndicator(
                                color = SurfaceLight,
                                strokeWidth = 2.dp,
                                modifier = Modifier.size(22.dp)
                            )

                        } else {

                            Text(
                                text = "KIRIM KODE VERIFIKASI",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                    if (pesan.isNotEmpty()) {

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Text(
                            text = pesan,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isSuccess) {
                                SuccessGreen
                            } else {
                                ErrorRed
                            }
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )
                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = "Kembali ke Login",
                            style = MaterialTheme.typography.labelLarge,
                            color = PrimaryBlue
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "SI ABSEN",
                style = MaterialTheme.typography.labelLarge,
                color = PrimaryBlue
            )

            Text(
                text = "Kalurahan Purwobinangun",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "© 2026 Kalurahan Purwobinangun",
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondary
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }
    }
}