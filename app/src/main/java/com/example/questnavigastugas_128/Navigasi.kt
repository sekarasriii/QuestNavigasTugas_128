package com.example.questnavigastugas_128

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas_128.viewmodel.PesertaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.collectAsState

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
}