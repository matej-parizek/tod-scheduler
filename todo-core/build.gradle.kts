plugins {
    // Apply the 'to-do.gradle.spring-boot-app' plugin for Spring Boot applications.
    id("todo.gradle.spring-boot-app")
}

dependencies {
    // Project dependency: Include the 'todo-api' project.
    implementation(project(":todo-api"))

    // Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Springdoc OpenAPI documentation
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.1.0")

    // Arrow for functional programming
    implementation("io.arrow-kt:arrow-core:1.2.0")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")

    // Kotlin supporting dependencies
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    // XML bind (needed for Swagger)
    runtimeOnly("javax.xml.bind:jaxb-api:2.3.1")

    // Test database
    implementation("com.h2database:h2")
    implementation("io.r2dbc:r2dbc-h2")
}
