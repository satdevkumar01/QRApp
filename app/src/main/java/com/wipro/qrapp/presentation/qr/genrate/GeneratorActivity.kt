package com.wipro.qrapp.presentation.qr.genrate

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.wipro.qrapp.R
import com.wipro.qrapp.presentation.viewmodels.QrGeneratorViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GeneratorActivity : AppCompatActivity() {

    // Initialize ViewModel using Hilt
    private val viewModel: QrGeneratorViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)
        lifecycleScope.launch {
            viewModel.macAddress.collect{data->
                findViewById<TextView>(R.id.tvData).text=data

            }
        }
        setupGenerateButton()
        observeQrCode()
    }

    private fun setupGenerateButton() {
        findViewById<Button>(R.id.btn_generate).setOnClickListener {
            viewModel.generateQrCode()
        }
    }

    private fun observeQrCode() {
        lifecycleScope.launch {
            viewModel.qrCode.collect { bitmap ->
                findViewById<ImageView>(R.id.iv_qr_code).setImageBitmap(bitmap)
            }
        }
    }
}