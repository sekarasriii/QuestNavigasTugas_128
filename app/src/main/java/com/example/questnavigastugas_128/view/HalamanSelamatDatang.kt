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


@Composable
fun HalamanSelamatDatang(
    onMulaiClick: () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Judul Selamat Datang
        Text(
            text = stringResource(id = R.string.selamat_datang),
            fontSize = dimensionResource(id = R.dimen.text_size_big_header).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_500)
        )
}