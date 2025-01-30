package com.wipro.qrapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp  // Required for Hilt DI
class QrApp : Application() {
    // Add global app configurations here if needed
}