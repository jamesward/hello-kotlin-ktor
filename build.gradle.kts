plugins {
    application
    kotlin("jvm") version "1.9.22"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.7")
    implementation("io.ktor:ktor-server-cio:2.3.7")
    implementation("io.ktor:ktor-server-call-logging:2.3.7")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.12")
}

application {
    mainClass = "WebAppKt"
}

kotlin {
    jvmToolchain(8)
}

tasks.replace("assemble").dependsOn("installDist")

tasks.create("stage").dependsOn("installDist")
