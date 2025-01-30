package com.wipro.qrapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.wipro.qrapp.domain.model.MacInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

// QrScannerViewModel.kt
@HiltViewModel
class QrScannerViewModel @Inject constructor() : ViewModel() {
    private val _scannedData = MutableStateFlow<MacInfo?>(null)
    val scannedData: StateFlow<MacInfo?> = _scannedData

    fun processScannedResult(result: String) {
        try {
            _scannedData.value = Gson().fromJson(result, MacInfo::class.java)
        } catch (e: Exception) {
        }
    }
}
