package com.example.si_absen.ui.admin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.si_absen.ui.theme.BackgroundLight
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SurfaceLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaporanScreen() {

    val context = LocalContext.current

    var periode by remember {
        mutableStateOf("September 2026")
    }

    var selected by remember {
        mutableStateOf("Semua Pegawai")
    }

    val pilihan = listOf(
        "Semua Pegawai",
        "Per Pegawai",
        "Semua Dukuh",
        "Per Dukuh",
        "Semua Data"
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Laporan",
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

            // =========================
            // RINGKASAN LAPORAN
            // =========================

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
                        text = "Ringkasan Laporan",
                        style = MaterialTheme.typography.titleMedium,
                        color = SurfaceLight
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "43",
                        style = MaterialTheme.typography.headlineMedium,
                        color = SurfaceLight
                    )

                    Text(
                        text = "Total Data Tersedia",
                        style = MaterialTheme.typography.bodyMedium,
                        color = SurfaceLight
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // PERIODE
            // =========================

            OutlinedTextField(
                value = periode,
                onValueChange = {
                    periode = it
                },
                label = {
                    Text(
                        text = "Periode",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // JENIS LAPORAN
            // =========================

            Text(
                text = "Jenis Laporan",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            pilihan.forEach { item ->

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    RadioButton(
                        selected = selected == item,
                        onClick = {
                            selected = item
                        }
                    )

                    Text(
                        text = item,
                        modifier = Modifier.padding(
                            top = 12.dp
                        ),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // PREVIEW LAPORAN
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SurfaceLight
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Preview Laporan",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Periode : $periode",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Jenis : $selected",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Total Data : 43",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Status : Siap Diekspor",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // =========================
            // EXPORT PDF
            // =========================

            Button(
                onClick = {

                    Toast.makeText(
                        context,
                        "Laporan PDF berhasil dibuat",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                )
            ) {

                Text(
                    text = "Export PDF",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // =========================
            // EXPORT EXCEL
            // =========================

            OutlinedButton(
                onClick = {

                    Toast.makeText(
                        context,
                        "Laporan Excel berhasil dibuat",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Export Excel",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // =========================
            // EXPORT CEPAT
            // =========================

            Text(
                text = "Export Cepat",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {

                    Toast.makeText(
                        context,
                        "Export Semua Pegawai",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Export Semua Pegawai",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {

                    Toast.makeText(
                        context,
                        "Export Per Pegawai",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Export Per Pegawai",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {

                    Toast.makeText(
                        context,
                        "Export Semua Dukuh",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Export Semua Dukuh",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {

                    Toast.makeText(
                        context,
                        "Export Per Dukuh",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Export Per Dukuh",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}