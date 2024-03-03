plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.fiicodeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fiicodeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.compose.material:material-icons-extended")
    implementation("com.android.support:support-v4:28.0.0")

    // Compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


    //Dagger and Hilt
    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")

    //Realm
    implementation("io.realm.kotlin:library-base:1.11.0")

    implementation("pl.coderion:openfoodfacts-java-wrapper:0.9.3"){
        exclude("io.netty", "netty-codec")
        exclude("io.netty","netty-transport")
        exclude("io.netty","netty-buffer")
        exclude("io.netty", "netty-codec-http")
        exclude("io.netty", "netty-codec-socks")
        exclude("io.micronaut","micronaut-router")
        exclude("io.micronaut","micronaut-validation")
        exclude("io.micronaut","micronaut-context")
        exclude("io.micronaut","micronaut-runtime")
        exclude("io.micronaut","micronaut-websocket")
        exclude("io.micronaut","micronaut-http-netty")
        exclude("io.micronaut","micronaut-http-server-netty")
        exclude("io.micronaut","micronaut-http")
        exclude("io.micronaut","micronaut-http-client")
        exclude("io.micronaut","micronaut-core")
        exclude("io.micronaut","micronaut-inject")
        exclude("io.micronaut","micronaut-http-client-core")
        exclude("ch.qos.logback", "logback-classic")
        exclude("ch.qos.logback", "logback-core")
        exclude("org.slf4j", "slf4j-api")
        exclude("org.apache.commons", "commons-lang3")
        exclude("org.reactivestreams", "reactive-streams")
        exclude("org.slf4j", "slf4j-api")
        exclude("javax.annotation","javax.annotation-api")
        configurations.all {
            resolutionStrategy{
                exclude("com.google.code.findbugs","jsr305")
                exclude("javax.inject","javax.inject")
            }
        }
    }
}