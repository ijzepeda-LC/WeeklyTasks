plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")

}
// TO UNDERSTAND AND HAVE MORE DETAILS OF VARIANT TYPES AND FLAVORS VISIT
//https://developer.android.com/build/build-variants?authuser=2


android {
    namespace = "com.hanson.maw24"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hanson.maw24" // TODO: change it<<<<<<<<<<<<<<<<<<<<<<<<
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
//            applicationIdSuffix= ".change_to_your_name_no_spaces_no_capitals" // TODO: change it<<<<<<<<<<<<<<<<<<<<<<<<
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        debug {
            applicationIdSuffix= ".debug" // TODO: change it<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            versionNameSuffix= "-debug-studentid"
        }
    }

    // Specifies one flavor dimension.
    flavorDimensions += "version"
    productFlavors {
        create("demo") {
            // Assigns this product flavor to the "version" flavor dimension.
            // If you are using only one dimension, this property is optional,
            // and the plugin automatically assigns all the module's flavors to
            // that dimension.
            dimension = "version"
            applicationIdSuffix = ".demo"
            versionNameSuffix = "-demo"
            // You can also use a different appid:
//            applicationId = "com.example.myapp.flavor1"
//            versionName =  "1.0-flavor1"
        }
        create("full") {
            dimension = "version"
//            applicationIdSuffix = ".full" // TODO: Uncommnent
            versionNameSuffix = "-full"
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.firebase:firebase-firestore-ktx:24.9.1") //TODO:Week 10
    implementation ("androidx.recyclerview:recyclerview:1.3.2")         // TODO: Week10

    //TODO: Week10
    // TODO: Add the dependencies for Firebase products you want to use
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")



}
