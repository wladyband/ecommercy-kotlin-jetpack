
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

            // ✅ Resolver o conflito de incremental processors
            pickFirsts += "META-INF/gradle/incremental.annotation.processors"

            // ✅ Prevenção de conflitos com arquivos comuns
            pickFirsts += "META-INF/LICENSE.md"
            pickFirsts += "META-INF/NOTICE.md"
            pickFirsts += "META-INF/LICENSE.txt"
            pickFirsts += "META-INF/NOTICE.txt"
            pickFirsts += "META-INF/LICENSE-notice.md"

            // ✅ Resolver o conflito atual
            excludes += "META-INF/versions/9/OSGI-INF/MANIFEST.MF"
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
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.converter.gson)
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
    implementation(libs.junit.jupiter)
    implementation(libs.junit.jupiter.params)
    implementation(libs.junit.jupiter)
    implementation(libs.junit.jupiter.params)
    implementation(libs.mockito.core)
    implementation(libs.mockito.kotlin)
    implementation(libs.assertj.core)
    implementation(libs.android.test.core)
    implementation(libs.android.test.runner)
    implementation(libs.espresso.core)
    implementation(libs.robolectric)
    implementation(libs.moshi.kotlin)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //gson

    implementation(libs.gson)
    implementation (libs.androidx.datastore.preferences)

    //navigation
    implementation (libs.androidx.navigation.compose)

    //dagger hilt
    implementation (libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)


    // JUnit 5 para testes unitários
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter.params)



// Mockito para mocks (caso precise no futuro)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)

// AssertJ para asserções mais legíveis
    testImplementation(libs.assertj.core)

// Extensão do JUnit 5 para Android
    testImplementation(libs.android.test.core)
    testImplementation(libs.android.test.runner)

// Espresso (já está incluído, mas necessário para testes instrumentados)
    androidTestImplementation(libs.espresso.core)

    testImplementation (libs.robolectric)

    // MOSHI
    implementation(libs.moshi.kotlin)

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

