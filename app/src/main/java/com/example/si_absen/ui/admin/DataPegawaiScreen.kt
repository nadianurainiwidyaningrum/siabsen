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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

data class PegawaiDummy(
    val id: Int,
    val nama: String,
    val nik: String,
    val jabatan: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataPegawaiScreen(
    navController: NavController
) {

    // ==========================================
    // STATE
    // ==========================================

    var search by remember {
        mutableStateOf("")
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    var namaBaru by remember {
        mutableStateOf("")
    }

    var nikBaru by remember {
        mutableStateOf("")
    }

    var jabatanBaru by remember {
        mutableStateOf("")
    }

    // ==========================================
    // DATA DUMMY
    // ==========================================

    val pegawaiList = listOf(

        PegawaiDummy(
            id = 1,
            nama = "Nadia Nuraini",
            nik = "340101",
            jabatan = "Sekretaris"
        ),

        PegawaiDummy(
            id = 2,
            nama = "Aina Rahmawati",
            nik = "340102",
            jabatan = "Staff Pelayanan"
        ),

        PegawaiDummy(
            id = 3,
            nama = "Tama",
            nik = "340103",
            jabatan = "Kaur Umum"
        ),

        PegawaiDummy(
            id = 4,
            nama = "Rizki",
            nik = "340104",
            jabatan = "Operator"
        )
    )

    // ==========================================
    // FILTER PENCARIAN
    // ==========================================

    val filteredList = pegawaiList.filter {

        it.nama.contains(
            search,
            ignoreCase = true
        ) ||

                it.nik.contains(
                    search,
                    ignoreCase = true
                )
    }

    // ==========================================
    // MAIN SCREEN
    // ==========================================

    Scaffold(

        // ======================================
        // TOP BAR
        // ======================================

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Data Pegawai",
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
                    showDialog = true
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
            // TOTAL PEGAWAI
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
                        text = "Total Pegawai",
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
                        text = "Cari Nama atau NIK"
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
            // DATA PEGAWAI
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

                ) { pegawai ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                                navController.navigate(
                                    Screen.DetailPegawai.route
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
                                text = pegawai.nama,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "NIK : ${pegawai.nik}",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = "Jabatan : ${pegawai.jabatan}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }

    // ==========================================
    // DIALOG TAMBAH PEGAWAI
    // ==========================================

    if (showDialog) {

        AlertDialog(

            onDismissRequest = {
                showDialog = false
            },

            title = {

                Text(
                    text = "Tambah Pegawai",
                    style = MaterialTheme.typography.titleLarge
                )
            },

            text = {

                Column {

                    // ==========================
                    // NAMA
                    // ==========================

                    OutlinedTextField(

                        value = namaBaru,

                        onValueChange = {
                            namaBaru = it
                        },

                        label = {
                            Text("Nama Lengkap")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    // ==========================
                    // NIK
                    // ==========================

                    OutlinedTextField(

                        value = nikBaru,

                        onValueChange = {
                            nikBaru = it
                        },

                        label = {
                            Text("NIK")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    // ==========================
                    // JABATAN
                    // ==========================

                    OutlinedTextField(

                        value = jabatanBaru,

                        onValueChange = {
                            jabatanBaru = it
                        },

                        label = {
                            Text("Jabatan")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true
                    )
                }
            },

            // ==================================
            // SIMPAN
            // ==================================

            confirmButton = {

                Button(

                    onClick = {

                        showDialog = false

                        namaBaru = ""
                        nikBaru = ""
                        jabatanBaru = ""
                    }

                ) {

                    Text(
                        text = "Simpan"
                    )
                }
            },

            // ==================================
            // BATAL
            // ==================================

            dismissButton = {

                TextButton(

                    onClick = {
                        showDialog = false
                    }

                ) {

                    Text(
                        text = "Batal"
                    )
                }
            }
        )
    }
}