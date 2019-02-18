import com.jfrog.bintray.gradle.BintrayExtension

plugins {
    `java-library`
    `maven-publish`
    id("io.franzbecker.gradle-lombok") version "2.0"
    id("com.jfrog.bintray") version "1.8.4"
    id("com.gradle.build-scan") version "2.1"
}

group = "io.github.alexbogovich"
version = "0.0.7"

repositories {
    jcenter()
}

val junit = "5.4.0"
val feign = "10.1.0"

dependencies {
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    api("io.github.openfeign:feign-core:$feign")
    implementation("io.github.openfeign:feign-jackson:$feign")
    implementation("io.github.openfeign:feign-jaxb:$feign")
    implementation("io.github.openfeign:feign-slf4j:$feign")
    implementation("org.apache.httpcomponents:httpclient:4.5.7")

    testImplementation("io.github.openfeign:feign-mock:$feign")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType(JavaCompile::class) {
    options.compilerArgs.add("-parameters")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("admitad") {
            from(components["java"])
        }
    }
}

bintray {
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_KEY")
    publish = true
    override = true
    setPublications("admitad")
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        repo = "repo"
        name = project.name
        userOrg = "alexbogovich"
        websiteUrl = "https://github.com/alexbogovich/$name"
        githubRepo = "alexbogovich/$name"
        vcsUrl = "https://github.com/alexbogovich/$name"
        description = "Admitad java connector"
        setLabels("java", "admitad")
        setLicenses("MIT")
    })
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    setTermsOfServiceAgree("yes")
}
