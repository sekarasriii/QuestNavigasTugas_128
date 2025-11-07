package com.example.questnavigastugas_128.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
fun ListDaftarPeserta(
    viewModel: PesertaViewModel,
    onBerandaBtnClick: () -> Unit,
    onTambahBtnClick: () -> Unit
) {
    val listPeserta by viewModel.listPeserta.collectAsState()

    Scaffold(
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (listPeserta.isEmpty()) {
                // Jika list kosong
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.belum_ada_peserta),
                        color = colorResource(id = R.color.gray)
                    )
                }
            } else {
                // Jika list ada isinya
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.card_spacing)
                    )
                ) {
                    itemsIndexed(listPeserta) { _, peserta ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.background_card)
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(
                                    dimensionResource(id = R.dimen.padding_medium)
                                )
                            ) {
                                // Nama Lengkap
                                Text(
                                    text = stringResource(id = R.string.nama_lengkap),
                                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                                    color = colorResource(id = R.color.gray)
                                )
                                Text(
                                    text = peserta.namaLengkap,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                                    modifier = Modifier.padding(
                                        bottom = dimensionResource(id = R.dimen.padding_extra_small)
                                    )
                                )

                                DividerSection()

                                // Jenis Kelamin
                                Text(
                                    text = stringResource(id = R.string.jenis_kelamin),
                                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                                    color = colorResource(id = R.color.gray)
                                )
                                Text(
                                    text = peserta.jenisKelamin,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                                    modifier = Modifier.padding(
                                        bottom = dimensionResource(id = R.dimen.padding_extra_small)
                                    )
                                )

                                DividerSection()

                                // Status Perkawinan
                                Text(
                                    text = stringResource(id = R.string.status_perkawinan),
                                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                                    color = colorResource(id = R.color.gray)
                                )
                                Text(
                                    text = peserta.statusPerkawinan,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                                    modifier = Modifier.padding(
                                        bottom = dimensionResource(id = R.dimen.padding_extra_small)
                                    )
                                )

                                DividerSection()

                                // Alamat
                                Text(
                                    text = stringResource(id = R.string.alamat),
                                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                                    color = colorResource(id = R.color.gray)
                                )
                                Text(
                                    text = peserta.alamat,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

            // Tombol Beranda
            Button(
                onClick = onBerandaBtnClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            ) {
                Text(text = stringResource(id = R.string.beranda))
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_extra_small)))

            // Tombol Formulir Pendaftaran
            Button(
                onClick = onTambahBtnClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.formulir_pendaftaran),
                    color = colorResource(id = R.color.purple_500)
                )
            }
        }
    }
}

@Composable
private fun DividerSection() {
    HorizontalDivider(
        thickness = dimensionResource(id = R.dimen.divider_thickness),
        color = colorResource(id = R.color.light_gray)
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_extra_small)))
}
