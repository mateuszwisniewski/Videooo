plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

apply(from = "$rootDir/quality/ktlint.gradle.kts")

android {
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.wisnia.videooo"
        minSdk = Android.MIN_SDK_VERSION
        targetSdk = Android.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "0.0.1"
    }

    signingConfigs {
        create("release") {
            val keystoreProperties = rootProject.file("$rootDir/${Property.KEYSTORE_PROPERTY_FILE_PATH}")
            if (keystoreProperties.exists()) {
                storeFile = file(loadProperty(keystoreProperties, Property.KEYSTORE_PATH_KEY))
                storePassword = loadProperty(keystoreProperties, Property.KEYSTORE_PASSWORD_KEY)
                keyAlias = loadProperty(keystoreProperties, Property.KEYSTORE_ALIAS_KEY)
                keyPassword = loadProperty(keystoreProperties, Property.KEYSTORE_ALIAS_PASSWORD_KEY)
            } else {
                storeFile = file(System.getenv("KEYSTORE"))
                storePassword = System.getenv("KEYSTORE_PASSWORD")
                keyAlias = System.getenv("ALIAS")
                keyPassword = System.getenv("ALIAS_PASSWORD")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }

        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(path = ":data"))
    implementation(project(path = ":domain"))

    implementation(Dependency.KOTLIN)
    implementation(Dependency.CORE_KTX)

    implementation(Dependency.LIFECYCLE_EXTENSIONS)
    implementation(Dependency.LIFECYCLE_VIEWMODEL)

    implementation(Dependency.CONSTRAINT_LAYOUT)
    implementation(Dependency.MATERIAL)

    implementation(Dependency.DAGGER)
    implementation(Dependency.DAGGER_SUPPORT)
    kapt(Dependency.DAGGER_PROCESSOR)
    kapt(Dependency.DAGGER_COMPILER)

    implementation(Dependency.GLIDE)
    kapt(Dependency.GLIDE_COMPILER)

    implementation(Dependency.RETROFIT)
    implementation(Dependency.RETROFIT_ADAPTER)
    implementation(Dependency.RETROFIT_CONVERTER)

    implementation(Dependency.RX_ANDROID)
    implementation(Dependency.RX_KOTLIN)

    implementation(Dependency.MOSHI)

    implementation(Dependency.NAVIGATION_FRAGMENT)
    implementation(Dependency.NAVIGATION_UI)

    // Tests
    testImplementation(Dependency.JUNIT)
    testImplementation(Dependency.CORE_TESTING)
    testImplementation(Dependency.KLUENT)
    testImplementation(Dependency.MOCKITO_KOTLIN)
}
