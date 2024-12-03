plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.xiaopang.xianyu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.xiaopang.xianyu"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }



}



dependencies {
    implementation("com.github.getActivity:XXPermissions:18.63") // 权限请求框架：https://github.com/getActivity/XXPermissions
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.caoccao.javet:javet-android:3.0.0") // Android (arm, arm64, x86 and x86_64)
    implementation("com.squareup.okhttp3:okhttp:4.12.0") // 网络请求框架

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}