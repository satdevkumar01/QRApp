package com.wipro.qrapp.domain.usecase

import com.wipro.qrapp.domain.model.MacInfo
import com.wipro.qrapp.domain.repository.MacRepository
import javax.inject.Inject

// GenerateQrUseCase.kt
class GenerateQrUseCase @Inject constructor(
    private val repository: MacRepository
) {
    suspend operator fun invoke(): MacInfo {
        val macAddress = repository.getMacAddress()
        return MacInfo(macAddress, System.currentTimeMillis())
    }
}