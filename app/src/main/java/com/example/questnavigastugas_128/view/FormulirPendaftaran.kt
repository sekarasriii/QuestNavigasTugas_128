package com.example.questnavigastugas_128.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.R
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.material3.TopAppBarDefaults

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

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.formulir_pendaftaran),
                        color = colorResource(id = R.color.white)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    )