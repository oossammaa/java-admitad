plugins {
    `java-library`
    id("io.franzbecker.gradle-lombok") version "2.0"
}

group = "io.github.alexbogovich"
version = "0.0.1"

repositories {
    jcenter()
}

val junit = "5.4.0"
val feign = "10.1.0"

dependencies {
    api("org.glassfish.jaxb:jaxb-runtime:2.3.2")
    api("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    api("io.github.openfeign:feign-core:$feign")
    api("io.github.openfeign:feign-jackson:$feign")
    api("io.github.openfeign:feign-jaxb:$feign")
    implementation("org.apache.httpcomponents:httpclient:4.5.7")

    testImplementation("io.github.openfeign:feign-mock:$feign")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
