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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import  androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

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
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            // Cek jika list kosong
            if (listPeserta.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.belum_ada_peserta),
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.gray)
                    )
                }
            } else {
                // Tampilkan list peserta
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.card_spacing)
                    )
                ) {
                    itemsIndexed(listPeserta) { index, peserta ->
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

                                HorizontalDivider(
                                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                                    color = colorResource(id = R.color.light_gray)
                                )

                                Spacer(modifier = Modifier.height(
                                    dimensionResource(id = R.dimen.padding_extra_small)
                                ))

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

                                HorizontalDivider(
                                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                                    color = colorResource(id = R.color.light_gray)
                                )

                                Spacer(modifier = Modifier.height(
                                    dimensionResource(id = R.dimen.padding_extra_small)
                                ))

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

                                HorizontalDivider(
                                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                                    color = colorResource(id = R.color.light_gray)
                                )

                                Spacer(modifier = Modifier.height(
                                    dimensionResource(id = R.dimen.padding_extra_small)
                                ))

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