plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    // Gradle plugins
    implementation("org.openapitools:openapi-generator-gradle-plugin:${property("openapi.version")}")
    implementation("com.gorylenko.gradle-git-properties:gradle-git-properties:${property("git-properties.version")}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${property("detekt.version")}")
    implementation("io.spring.gradle:dependency-management-plugin:${property("dependency-management.version")}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${property("dokka.version")}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${property("kotlin.version")}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlin.version")}")
    implementation("org.jetbrains.kotlin:kotlin-noarg:${property("kotlin.version")}")
    implementation("org.jmailen.gradle:kotlinter-gradle:${property("kotlinter.version")}")
    implementation("org.owasp:dependency-check-gradle:${property("dependency-check.version")}")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${property("sonarqube.version")}")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${property("spring-boot.version")}")
}
