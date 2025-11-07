package com.example.questnavigastugas_128.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_128.R
import com.example.questnavigastugas_128.viewmodel.Peserta  // pastikan path ini sesuai dengan lokasi model kamu


@Composable
fun Konfirmasi(
    peserta: Peserta,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(id = R.string.konfirmasi_data),
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.text_size_title).value.sp
            )
        },
        text = {
            Column {
                // Pesan konfirmasi
                Text(
                    text = stringResource(id = R.string.konfirmasi_message),
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.card_spacing)))

                // --- NAMA LENGKAP ---
                Text(
                    text = stringResource(id = R.string.nama_lengkap),
                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                    color = colorResource(id = R.color.gray)
                )
                Text(
                    text = peserta.namaLengkap,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.card_spacing))
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.light_gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.card_spacing)))

                // --- JENIS KELAMIN ---
                Text(
                    text = stringResource(id = R.string.jenis_kelamin),
                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                    color = colorResource(id = R.color.gray)
                )
                Text(
                    text = peserta.jenisKelamin,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.card_spacing))
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.light_gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.card_spacing)))

                // --- STATUS PERKAWINAN ---
                Text(
                    text = stringResource(id = R.string.status_perkawinan),
                    fontSize = dimensionResource(id = R.dimen.text_size_extra_small).value.sp,
                    color = colorResource(id = R.color.gray)
                )
                Text(
                    text = peserta.statusPerkawinan,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.card_spacing))
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.light_gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.card_spacing)))

                // --- ALAMAT ---
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
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.batal))
            }
        }
    )
}
