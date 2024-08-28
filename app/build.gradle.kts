plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.google.dagger.hilt.android)
    alias(libs.plugins.androidx.navigation.safeargs.kotlin)
}

android {
    namespace = "com.example.apphoroscopo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.apphoroscopo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.apphoroscopo.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "APPLICATION_NAME", "Horoscopo App")

            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug"){
            resValue("string", "APPLICATION_NAME", "[DEBUG] HoroscopoApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    //NavigationComponent
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)

    //DaggerHilt
    implementation(libs.hilt.android)
    testImplementation(libs.junit.jupiter)
    kapt(libs.hilt.compiler)

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)

    //Camera X
    implementation (libs.androidx.camera.core)
    implementation (libs.androidx.camera.camera2)
    implementation (libs.androidx.camera.lifecycle)
    implementation (libs.androidx.camera.view)
    implementation (libs.androidx.camera.extensions)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //UnitTesting
    testImplementation(libs.junit)
    testImplementation (libs.kotlintest.runner.junit5)
    testImplementation (libs.mockk)

    //UITesting
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.6.1")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.6.1")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.48")
    androidTestImplementation ("androidx.fragment:fragment-testing:1.6.1")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")
}