package com.example.questnavigastugas_128.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_128.R
import com.example.questnavigastugas_128.viewmodel.PesertaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirPendaftaran(
    viewModel: PesertaViewModel,
    onSubmitBtnClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val jenisKelamin = listOf(
        stringResource(id = R.string.laki_laki),
        stringResource(id = R.string.perempuan)
    )

    val statusPerkawinan = listOf(
        stringResource(id = R.string.lajang),
        stringResource(id = R.string.janda),
        stringResource(id = R.string.duda)
    )

    Scaffold(
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
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- NAMA LENGKAP ---
            Text(
                text = stringResource(id = R.string.nama_lengkap),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_extra_small)),
                fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                value = uiState.namaLengkap,
                onValueChange = { viewModel.setNamaLengkap(it) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.placeholder_nama)) }
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

            // --- JENIS KELAMIN ---
            Text(
                text = stringResource(id = R.string.jenis_kelamin),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_extra_small)),
                fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                fontWeight = FontWeight.SemiBold
            )

            jenisKelamin.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = uiState.jenisKelamin == item,
                        onClick = { viewModel.setJenisKelamin(item) }
                    )
                    Text(text = item)
                }
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

            // --- STATUS PERKAWINAN ---
            Text(
                text = stringResource(id = R.string.status_perkawinan),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_extra_small)),
                fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                fontWeight = FontWeight.SemiBold
            )

            statusPerkawinan.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = uiState.statusPerkawinan == item,
                        onClick = { viewModel.setStatusPerkawinan(item) }
                    )
                    Text(text = item)
                }
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

            // --- ALAMAT ---
            Text(
                text = stringResource(id = R.string.alamat),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_extra_small)),
                fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                value = uiState.alamat,
                onValueChange = { viewModel.setAlamat(it) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.placeholder_alamat)) }
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_extra_large)))

            // --- TOMBOL SUBMIT ---
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSubmitBtnClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
