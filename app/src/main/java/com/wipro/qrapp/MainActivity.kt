package com.wipro.qrapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wipro.qrapp.presentation.qr.genrate.GeneratorActivity
import com.wipro.qrapp.presentation.qr.scan.ScannerActivity
import dagger.hilt.android.AndroidEntryPoint

// In your MainActivity
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_generate).setOnClickListener {
            startActivity(Intent(this, GeneratorActivity::class.java))
        }

        findViewById<Button>(R.id.btn_scan).setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }
    }
}