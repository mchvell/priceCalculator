plugins {
    kotlin("jvm") version "2.0.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("PriceCalculatorKt")
}

tasks.test {
    useJUnitPlatform()
}
