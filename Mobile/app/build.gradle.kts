
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.compose) // <- novo
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.bandeira.ecommerceappmvvm.prese"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bandeira.ecommerceappmvvm.prese"
        minSdk = 25
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    tasks.withType<Test> {
        testLogging {
            events("passed", "skipped", "failed")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()  // Ativa o suporte ao JUnit 5
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    //navigation
    implementation ("androidx.navigation:navigation-compose:2.8.7")

    //dagger hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")

    // JUnit 5 para testes unitários
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")

// Mockito para mocks (caso precise no futuro)
    testImplementation("org.mockito:mockito-core:5.4.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")

// AssertJ para asserções mais legíveis
    testImplementation("org.assertj:assertj-core:3.24.2")

// Extensão do JUnit 5 para Android
    testImplementation("de.mannodermaus.junit5:android-test-core:1.3.0")
    androidTestImplementation("de.mannodermaus.junit5:android-test-runner:1.3.0")

// Espresso (já está incluído, mas necessário para testes instrumentados)
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    testImplementation ("org.robolectric:robolectric:4.7")

    // MOSHI
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

}

kapt {
    correctErrorTypes = true
}

//atalho ./gradlew test --stacktrace
//./gradlew test --info
// ./gradlew clean test --info
// ./gradlew clean build --refresh-dependencies

kapt {
    correctErrorTypes = true
    javacOptions {
        option("-Xplugin=org.jetbrains.kotlin.kapt3.KaptOptionsKt", "")
        option("-J--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
    }
}

