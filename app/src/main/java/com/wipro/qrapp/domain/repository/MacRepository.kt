package com.wipro.qrapp.domain.repository

// MacRepository.kt (interface)
interface MacRepository {
    suspend fun getMacAddress(): String
}