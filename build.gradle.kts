plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    id("org.jetbrains.kotlin.kapt") version "1.9.24" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
}
