plugins {
    kotlin("jvm") version "2.0.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
}

application {
    mainClass.set("PriceCalculatorKt")
}

tasks.test {
    useJUnitPlatform()
}
