package com.wipro.qrapp.data

import android.content.Context
import android.net.wifi.WifiManager
import android.widget.Toast
import com.wipro.qrapp.domain.repository.MacRepository
import javax.inject.Inject

// MacRepositoryImpl.kt
class MacRepositoryImpl @Inject constructor(
    private val context: Context
) : MacRepository {
    override suspend fun getMacAddress(): String {

        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val address =wifiManager.connectionInfo.macAddress
        Toast.makeText(context,"Addrss :$address",Toast.LENGTH_LONG).show()
        return address
    }
}