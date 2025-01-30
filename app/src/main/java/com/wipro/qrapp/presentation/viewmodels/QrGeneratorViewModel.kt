package com.wipro.qrapp.presentation.viewmodels

import android.graphics.Bitmap
import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.wipro.qrapp.domain.model.MacInfo
import com.wipro.qrapp.domain.usecase.GenerateQrUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
// QrGeneratorViewModel.kt
@HiltViewModel
class QrGeneratorViewModel @Inject constructor(
    private val generateQrUseCase: GenerateQrUseCase
) : ViewModel() {
    private val _qrCode = MutableStateFlow<Bitmap?>(null)
    val qrCode: StateFlow<Bitmap?> = _qrCode
    private val _macAddress = MutableStateFlow<String?>(null)
    val macAddress: StateFlow<String?> = _macAddress

    fun generateQrCode() {
        viewModelScope.launch {
            generateQrUseCase().let { macInfo ->
                _macAddress.value="This Mac Address : ${macInfo.macAddress} and this timestamp : ${macInfo.timestamp}"
                _qrCode.value = generateQrBitmap(macInfo)
            }
        }
    }



    private fun generateQrBitmap(macInfo: MacInfo): Bitmap {
        val json = Gson().toJson(macInfo)
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(json, BarcodeFormat.QR_CODE, 512, 512)

        // Create Bitmap directly from BitMatrix using a loop
        val bitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.RGB_565)
        for (x in 0 until 512) {
            for (y in 0 until 512) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }
}