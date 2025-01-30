package com.wipro.qrapp.presentation.qr.scan

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.wipro.qrapp.R
import com.wipro.qrapp.presentation.viewmodels.QrScannerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ScannerActivity: AppCompatActivity() {

    private val viewModel: QrScannerViewModel by viewModels()

    private val launcher = registerForActivityResult(
        ScanContract()
    ) { result ->
        if (result.contents!= null) {
            viewModel.processScannedResult(result.contents)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        val surfaceView = findViewById<SurfaceView>(R.id.surface_view)
        val scanResultTextView = findViewById<TextView>(R.id.tv_scan_result)
        val backButton = findViewById<ImageButton>(R.id.btn_back)

        // Check for camera permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 101)
        } else {
            setupScanner()
        }
        lifecycleScope.launch {
            viewModel.scannedData.collect { macInfo ->
                val macAddress = macInfo?.macAddress
                scanResultTextView.text = "Scanned MAC: $macAddress"
                scanResultTextView.visibility = View.VISIBLE
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun setupScanner() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a QR Code")
        options.setCameraId(0)  // Use a specific camera of the device
        options.setBeepEnabled(false)
        options.setBarcodeImageEnabled(true)
        launcher.launch(options)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupScanner()
        } else {
            Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }
}