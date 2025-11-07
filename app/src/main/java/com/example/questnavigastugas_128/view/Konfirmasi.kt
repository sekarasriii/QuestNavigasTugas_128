package com.example.questnavigastugas_128.view

import androidx.compose.runtime.Composable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.dimensionResource
import  androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.sp

@Composable
fun Konfirmasi(
    peserta: Peserta,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
){
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
                Text(
                    text = stringResource(id = R.string.konfirmasi_message),
                    modifier = Modifier.padding(
                        bottom = dimensionResource(id = R.dimen.padding_medium)
                    )
                )
                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_card_spacing)))

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
                        bottom = dimensionResource(id = R.dimen.padding_card_spacing)
                    )
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.light_gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_card_spacing)))

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
                        bottom = dimensionResource(id = R.dimen.padding_card_spacing)
                    )
                )

                HorizontalDivider(
                    thickness = dimensionResource(id = R.dimen.divider_thickness),
                    color = colorResource(id = R.color.light_gray)
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_card_spacing)))
}