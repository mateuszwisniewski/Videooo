buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Version.PLUGIN_GRADLE}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.PLUGIN_KOTLIN}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
