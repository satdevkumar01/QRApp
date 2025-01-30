# QR Code Generator and Scanner

This Android application allows users to generate QR codes containing MAC address information and scan QR codes to retrieve the embedded data. The project follows Clean Architecture, MVVM pattern, and uses modern Android development tools like Hilt for dependency injection, Kotlin Coroutines, and Jetpack libraries.

## Features

### QR Code Generation
- Generates a QR code containing the device's MAC address and a timestamp
- Displays the generated QR code on the screen

### QR Code Scanning
- Scans QR codes and extracts the embedded MAC address and timestamp
- Displays the scanned data on the screen

### Clean Architecture
- Separates the project into Data, Domain, and Presentation layers for better maintainability and testability

### Dependency Injection
- Uses Hilt for dependency injection to manage dependencies across the app

### MVVM Pattern
- Follows the Model-View-ViewModel pattern to separate UI logic from business logic

### Unit Testing
- Includes unit tests for ViewModels, Use Cases, and Repositories

## Technologies Used

- **Kotlin**: Primary programming language
- **Hilt**: For dependency injection
- **ZXing**: For QR code generation and scanning
- **Jetpack Libraries**:
    - ViewModel
    - LiveData
    - StateFlow
    - Activity/Fragment KTX
- **Coroutines**: For asynchronous programming
- **Material Design**: For UI components and theming

## Project Structure

The project is organized into the following layers:

### 1. Data Layer
Contains the data sources (local, remote) and repository implementations.

Files:
- MacRepositoryImpl.kt
- QrCodeDataSource.kt

### 2. Domain Layer
Contains the business logic, use cases, and repository interfaces.

Files:
- MacInfo.kt
- GenerateQrUseCase.kt
- MacRepository.kt

### 3. Presentation Layer
Contains UI components (Activities, Fragments, ViewModels) and UI logic.

Files:
- GeneratorActivity.kt
- ScannerActivity.kt
- QrGeneratorViewModel.kt
- QrScannerViewModel.kt

### 4. DI Layer
Contains Hilt modules for dependency injection.

Files:
- AppModule.kt

## Setup Instructions

### Prerequisites
- Android Studio (latest stable version)
- Android SDK (API level 24 or higher)
- Kotlin plugin (installed by default in Android Studio)

### Steps to Run the Project

1. **Clone the Repository**:
```bash
git clone https://github.com/satdevkumar01/qr-code-generator-scanner.git
```

2. **Open the Project**:
    - Open Android Studio and select Open an Existing Project
    - Navigate to the cloned repository and select the project

3. **Build the Project**:
    - Click on Build > Make Project to build the project and resolve dependencies

4. **Run the Project**:
    - Connect an Android device or start an emulator
    - Click on Run > Run 'app' to install and launch the app

## Permissions

The app requires the following permissions:

### Camera Permission
Used for scanning QR codes.

Add the following to AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.CAMERA"/>
```

### WiFi Permission
Used to retrieve the device's MAC address.

Add the following to AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
```

## Testing

The project includes unit tests for ViewModels, Use Cases, and Repositories. To run the tests:

1. Open the test folder in the src directory
2. Right-click on the test file and select Run

## Dependencies

The project uses the following dependencies:
- Hilt: For dependency injection
- ZXing: For QR code generation and scanning
- Jetpack Libraries: For ViewModel, LiveData, and StateFlow
- Coroutines: For asynchronous programming
- Material Design: For UI components

See the build.gradle.kts files for the complete list of dependencies.

## Screenshots
[Include screenshots of the app here]

## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to open a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contact

For any questions or feedback, please contact:
- Your Name: satdevsokhal1995@gmail.com
- GitHub: satdevkumar01