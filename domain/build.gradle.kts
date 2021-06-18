plugins {
    id("kotlin")
}
apply(from = "../quality/ktlint.gradle.kts")

dependencies {
    implementation(Dependency.INJECT)
    implementation(Dependency.KOTLIN)
    implementation(Dependency.MOSHI)
    implementation(Dependency.RX_ANDROID)

    testImplementation(Dependency.JUNIT)
    testImplementation(Dependency.KLUENT)
    testImplementation(Dependency.MOCKITO_KOTLIN)
}
