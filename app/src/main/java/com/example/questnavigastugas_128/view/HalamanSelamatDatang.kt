package com.example.questnavigastugas_128.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_128.R

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
        // Judul utama
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

        // Identitas Mahasiswa
        Text(
            text = stringResource(id = R.string.student_name),
            fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
        )

        Text(
            text = stringResource(id = R.string.student_id),
            fontSize = dimensionResource(id = R.dimen.text_size_small).value.sp,
            color = colorResource(id = R.color.gray)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xl)))

        // Tombol Mulai
        Button(
            onClick = onMulaiClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.purple_500)
            )
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}
