plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "me.y9san9"
version = "1.0"

repositories {
    mavenCentral()
}



kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}