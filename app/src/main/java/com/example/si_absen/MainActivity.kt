package com.example.si_absen

import com.example.si_absen.ui.theme.SiabsenTheme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.si_absen.ui.navigation.AppNavGraph


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            SiabsenTheme {

                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController
                )
            }
        }
    }
}