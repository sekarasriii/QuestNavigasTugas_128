package com.example.questnavigastugas_128.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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

    // Update nama lengkap
    fun setNamaLengkap(nama: String) {
        _uiState.update { currentState ->
            currentState.copy(namaLengkap = nama)
        }
    }

    // Update jenis kelamin
    fun setJenisKelamin(jk: String) {
        _uiState.update { currentState ->
            currentState.copy(jenisKelamin = jk)
        }
    }

    // Update status perkawinan
    fun setStatusPerkawinan(status: String) {
        _uiState.update { currentState ->
            currentState.copy(statusPerkawinan = status)
        }
    }

    // Update alamat
    fun setAlamat(alamat: String) {
        _uiState.update { currentState ->
            currentState.copy(alamat = alamat)
        }
    }

    // Simpan data peserta ke list
    fun simpanDataPeserta() {
        _listPeserta.update { currentList ->
            currentList + _uiState.value
        }
        // Reset form setelah simpan
        resetForm()
    }

    // Reset form ke kondisi awal
    private fun resetForm() {
        _uiState.value = Peserta()
    }
}