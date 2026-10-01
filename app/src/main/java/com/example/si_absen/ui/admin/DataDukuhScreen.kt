package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

data class DukuhDummy(
    val id: Int,
    val nama: String,
    val wilayah: String,
    val noHp: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataDukuhScreen(
    navController: NavController
) {

    var search by remember {
        mutableStateOf("")
    }

    // ==========================================
    // DATA DUMMY
    // ==========================================

    val dukuhList = listOf(
        DukuhDummy(
            id = 1,
            nama = "Budi Santoso",
            wilayah = "Klepu",
            noHp = "081234567891"
        ),

        DukuhDummy(
            id = 2,
            nama = "Slamet Riyadi",
            wilayah = "Ngaglik",
            noHp = "081234567892"
        ),

        DukuhDummy(
            id = 3,
            nama = "Agus Prasetyo",
            wilayah = "Ngebel",
            noHp = "081234567893"
        ),

        DukuhDummy(
            id = 4,
            nama = "Rudi Hartono",
            wilayah = "Purwobinangun",
            noHp = "081234567894"
        )
    )

    // ==========================================
    // FILTER PENCARIAN
    // ==========================================

    val filteredList = dukuhList.filter {

        it.nama.contains(
            search,
            ignoreCase = true
        ) ||

                it.wilayah.contains(
                    search,
                    ignoreCase = true
                )
    }

    Scaffold(

        // ======================================
        // TOP BAR
        // ======================================

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Data Dukuh",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },

        // ======================================
        // FLOATING ACTION BUTTON
        // ======================================

        floatingActionButton = {

            FloatingActionButton(

                onClick = {
                    // TODO:
                    // navigasi ke halaman tambah dukuh
                },

                containerColor = PrimaryBlue,

                contentColor = SurfaceLight

            ) {

                Text(
                    text = "+",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundLight)
                .padding(paddingValues)
                .padding(16.dp)

        ) {

            // ==================================
            // TOTAL DUKUH
            // ==================================

            Card(

                modifier = Modifier.fillMaxWidth(),

                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
                ),

                shape = RoundedCornerShape(16.dp)

            ) {

                Column(

                    modifier = Modifier.padding(16.dp)

                ) {

                    Text(
                        text = "Total Dukuh",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "${filteredList.size}",
                        color = SurfaceLight,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // ==================================
            // SEARCH
            // ==================================

            OutlinedTextField(

                value = search,

                onValueChange = {
                    search = it
                },

                label = {
                    Text(
                        text = "Cari Nama / Wilayah"
                    )
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(12.dp),

                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // ==================================
            // DATA DUKUH
            // ==================================

            LazyColumn(

                modifier = Modifier.fillMaxSize(),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(
                    items = filteredList,
                    key = {
                        it.id
                    }
                ) { dukuh ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                navController.navigate(
                                    Screen.DetailDukuh.route
                                )
                            },

                        shape = RoundedCornerShape(16.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = SurfaceLight
                        ),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )

                    ) {

                        Column(

                            modifier = Modifier.padding(16.dp)

                        ) {

                            Text(
                                text = dukuh.nama,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Wilayah : ${dukuh.wilayah}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "No HP : ${dukuh.noHp}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}