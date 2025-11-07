package com.example.questnavigastugas_128

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas_128.viewmodel.PesertaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.composable
import com.example.questnavigastugas_128.view.HalamanSelamatDatang
import com.example.questnavigastugas_128.view.FormulirPendaftaran
import com.example.questnavigastugas_128.view.Konfirmasi
import com.example.questnavigastugas_128.view.ListDaftarPeserta

enum class Navigasi {
    Home,
    Formulir,
    ListPeserta
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    viewModel: PesertaViewModel = viewModel()
){
    var showDialog by remember { mutableStateOf(false) }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            // Halaman 1: Selamat Datang
            composable(route = Navigasi.Home.name) {
                HalamanSelamatDatang(
                    onMulaiClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }

            // Halaman 2: Formulir Pendaftaran
            composable(route = Navigasi.Formulir.name) {
                FormulirPendaftaran(
                    viewModel = viewModel,
                    onSubmitBtnClick = {
                        // Tampilkan dialog konfirmasi sebelum submit
                        showDialog = true
                    }
                )

                // Pop-up Dialog Konfirmasi
                if (showDialog) {
                    Konfirmasi(
                        peserta = uiState,
                        onConfirm = {
                            // Simpan data peserta
                            viewModel.simpanDataPeserta()
                            // Tutup dialog
                            showDialog = false
                            // Navigasi ke halaman list peserta
                            navController.navigate(Navigasi.ListPeserta.name) {
                                // Clear back stack sampai home
                                popUpTo(Navigasi.Home.name)
                            }
                        },
                        onDismiss = {
                            // Tutup dialog tanpa menyimpan
                            showDialog = false
                        }
                    )
                }
            }

            // Halaman 3: List Daftar Peserta
            composable(route = Navigasi.ListPeserta.name) {
                ListDaftarPeserta(
                    viewModel = viewModel,
                    onBerandaBtnClick = {
                        // Kembali ke halaman home dan clear semua back stack
                        navController.navigate(Navigasi.Home.name) {
                            popUpTo(Navigasi.Home.name) {
                                inclusive = true
                            }
                        }
                    },
                    onTambahBtnClick = {
                        // Ke halaman formulir untuk tambah peserta baru
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }
        }
    }
}