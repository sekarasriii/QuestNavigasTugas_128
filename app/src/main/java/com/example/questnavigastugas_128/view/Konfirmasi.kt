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
}