package com.example.questnavigastugas_128.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDaftarPeserta(
    viewModel: PesertaViewModel,
    onBerandaBtnClick: () -> Unit,
    onTambahBtnClick: () -> Unit
) {
    val listPeserta by viewModel.listPeserta.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.list_daftar_peserta),
                        color = colorResource(id = R.color.white)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) {}
}