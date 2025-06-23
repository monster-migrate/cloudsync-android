import java.util.Properties
val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

val weatherApiBaseUrl: String = localProperties.getProperty("WEATHER_API_BASE_URL")
val locationApiBaseUrl: String = localProperties.getProperty("LOCATION_API_BASE_URL")
val airQualityApiBaseUrl: String = localProperties.getProperty("AIRQUALITY_API_BASE_URL")
val weatherApiTimeout: String = localProperties.getProperty("WEATHER_API_TIMEOUT")

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.dev.cloudsync"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dev.cloudsync"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "WEATHER_API_BASE_URL", "\"$weatherApiBaseUrl\"")
        buildConfigField("String", "LOCATION_API_BASE_URL", "\"$locationApiBaseUrl\"")
        buildConfigField("String", "AIRQUALITY_API_BASE_URL", "\"$airQualityApiBaseUrl\"")
        buildConfigField("String", "WEATHER_API_TIMEOUT", "\"$weatherApiTimeout\"")
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.retrofit)
    implementation(libs.retrofitGSONConverter)
    implementation(libs.shimmer)
}