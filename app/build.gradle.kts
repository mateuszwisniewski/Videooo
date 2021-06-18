plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

//apply(from = "../quality/jacoco.gradle")
apply(from = "../quality/ktlint.gradle.kts")

android {
    compileSdkVersion(Android.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = "com.wisnia.videooo"
        minSdkVersion(Android.MIN_SDK_VERSION)
        targetSdkVersion(Android.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "0.0.1"
    }

    signingConfigs {
        create("release") {
            try {
                storeFile = file(Properties.KEYSTORE_PATH)
                storePassword = Properties.KEYSTORE_PASSWORD
                keyAlias = Properties.KEYSTORE_ALIAS
                keyPassword = Properties.KEYSTORE_ALIAS_PASSWORD
            } catch (ignored: Exception) {
                throw InvalidUserDataException(
                    "You have to define: KEYSTORE, KEYSTORE_PASSWORD, ALIAS, ALIAS_PASSWORD " +
                            "in secure/keystore.properties file"
                )
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
    testImplementation(Dependency.KLUENT)
    testImplementation(Dependency.MOCKITO_KOTLIN)
}
