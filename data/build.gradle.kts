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

        val tmdbProperties = rootProject.file("$rootDir/${Property.TMDB_PROPERTY_FILE_PATH}")
        buildConfigField("String", Property.TMDB_API_URL, loadProperty(tmdbProperties, Property.TMDB_API_URL))
        buildConfigField("String", Property.TMDB_API_KEY, loadProperty(tmdbProperties, Property.TMDB_API_KEY))
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
