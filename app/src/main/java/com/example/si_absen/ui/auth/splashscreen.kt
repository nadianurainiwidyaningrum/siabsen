package com.example.si_absen.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SecondaryBlue
import com.example.si_absen.ui.theme.SurfaceLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    LaunchedEffect(Unit) {

        delay(2500)

        navController.navigate(
            Screen.Login.route
        ) {
            popUpTo(0)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        PrimaryBlue,
                        SecondaryBlue
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SI ABSEN",
                color = SurfaceLight,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Sistem Informasi Absensi Pegawai",
                color = SurfaceLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Kalurahan Purwobinangun",
                color = SurfaceLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            CircularProgressIndicator(
                color = SurfaceLight
            )
        }

        Text(
            text = "© Kalurahan Purwobinangun",
            color = SurfaceLight,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}