plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "../quality/ktlint.gradle.kts")

android {
    compileSdkVersion(Android.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(Android.MIN_SDK_VERSION)
        targetSdkVersion(Android.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "0.0.1"

        buildConfigField("String", Properties.TMDB_API_URL.first, Properties.TMDB_API_URL.second)
        buildConfigField("String", Properties.TMDB_API_KEY.first, Properties.TMDB_API_KEY.second)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(path = ":domain"))

    implementation(Dependency.KOTLIN)
    implementation(Dependency.RETROFIT)
    implementation(Dependency.RETROFIT_ADAPTER)
    implementation(Dependency.RETROFIT_CONVERTER)
    implementation(Dependency.MOSHI)
    implementation(Dependency.INJECT)
    implementation(Dependency.RX_KOTLIN)

    testImplementation(Dependency.JUNIT)
    testImplementation(Dependency.KLUENT)
    testImplementation(Dependency.MOCKITO_KOTLIN)
}
