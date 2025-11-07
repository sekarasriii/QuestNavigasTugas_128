package com.example.questnavigastugas_128.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirPendaftaran(
    viewModel: PesertaViewModel,
    onSubmitBtnClick: () -> Unit
){
    val uiState by viewModel.uiState.collectAsState()
    val jenisKelamin = listOf(
        stringResource(id = R.string.laki_laki),
        stringResource(id = R.string.perempuan)
    )
    val statusPerkawinan = listOf(
        stringResource(id = R.string.janda),
        stringResource(id = R.string.lajang),
        stringResource(id = R.string.duda)
    )