plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")

}

android {
    namespace = "pe.cibertec.proyecto"
    compileSdk = 34

    defaultConfig {
        applicationId = "pe.cibertec.proyecto"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {// Biblioteca Kotlin para Android
    implementation("androidx.core:core-ktx:1.12.0")

    // Biblioteca de compatibilidad de Android
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Design Components para Android
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.8.0")

    // Pruebas unitarias con JUnit
    testImplementation("junit:junit:4.13.2")

    // Pruebas de instrumentación con JUnit
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Importa el BoM (Bill of Materials) para la plataforma de Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))

    // Biblioteca para integrar Firebase Analytics
    implementation("com.google.firebase:firebase-analytics")

    // Biblioteca para integrar Firebase Authentication
    implementation("com.google.firebase:firebase-auth")

    //splashscreen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Importar Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
}