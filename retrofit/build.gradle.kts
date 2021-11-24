import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "me.jens"
version = "1.0-SNAPSHOT"

dependencies {
    implementation (project(":core"))
       implementation ("io.reactivex.rxjava3:rxjava:3.1.2")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    testImplementation(kotlin("test"))
    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
}
repositories {
    mavenCentral()
}
tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}