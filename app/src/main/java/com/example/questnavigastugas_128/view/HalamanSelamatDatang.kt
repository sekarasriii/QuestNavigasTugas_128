package com.example.questnavigastugas_128.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Arrangement
import  androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp

@Composable
fun HalamanSelamatDatang(
    onMulaiClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul Selamat Datang
        Text(
            text = stringResource(id = R.string.selamat_datang),
            fontSize = dimensionResource(id = R.dimen.text_size_big_header).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_500)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xl)))

        Image(
            painter = painterResource(id = R.drawable.saturn), // Ganti dengan nama file gambar kamu
            contentDescription = stringResource(id = R.string.app_title),
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

        Text(
            text = stringResource(id = R.string.app_title),
            fontSize = dimensionResource(id = R.dimen.text_size_header).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_700)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

        // Subtitle
        Text(
            text = stringResource(id = R.string.app_subtitle),
            fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
        )

        Text(
            text = stringResource(id = R.string.app_year),
            fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xl)))
    }
}