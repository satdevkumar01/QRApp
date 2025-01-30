plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    kotlin("kapt")
}

android {
    namespace = "com.wipro.qrapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.wipro.qrapp"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // QR Code
    implementation(libs.zxing.core)
    implementation(libs.zxing.android.embedded)

    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Architecture Components
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.gson)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    // Testing
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.turbine)
}