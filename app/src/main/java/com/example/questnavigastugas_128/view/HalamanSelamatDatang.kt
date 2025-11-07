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
    )
}