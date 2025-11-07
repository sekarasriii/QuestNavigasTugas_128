package com.example.questnavigastugas_128.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Peserta(
    val namaLengkap: String = "",
    val jenisKelamin: String = "",
    val statusPerkawinan: String = "",
    val alamat: String = ""
)
class PesertaViewModel : ViewModel() {
    // State untuk form input saat ini
    private val _uiState = MutableStateFlow(Peserta())
    val uiState: StateFlow<Peserta> = _uiState.asStateFlow()

    // State untuk list semua peserta yang sudah terdaftar
    private val _listPeserta = MutableStateFlow<List<Peserta>>(emptyList())
    val listPeserta: StateFlow<List<Peserta>> = _listPeserta.asStateFlow()