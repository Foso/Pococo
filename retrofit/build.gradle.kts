import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "me.jens"
version = "1.0-SNAPSHOT"

dependencies {
    implementation (project(":core"))
    implementation ("io.reactivex.rxjava3:rxjava:3.1.3")
    implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")

    testImplementation(kotlin("test"))
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