plugins {
    id("org.openapi.generator")
}

tasks.named("compileKotlin").configure {
    dependsOn(tasks.named("openApiGenerate"))
}

openApiGenerate {
    // Generator configuration
    generatorName.set("kotlin-spring")  // Use the Kotlin Spring generator
    inputSpec.set("$rootDir/todo-api/src/main/resources/todo-api.yaml")  // Specify the input OpenAPI spec file
    outputDir.set("$rootDir/todo-api/build/generated")  // Set the output directory for generated code

    // Package names
    apiPackage.set("com.todo.api")  // API package
    modelPackage.set("com.todo.model")  // Model package

    // Validation options
    skipValidateSpec.set(true)  // Skip validation of the OpenAPI spec
    validateSpec.set(false)  // Disable validation

    // Additional configuration options
    configOptions.set(mapOf(
        "dateLibrary" to "java8",  // Use Java 8 date library
        "useSpringBoot3" to "true",  // Enable Spring Boot 3 features
        "interfaceOnly" to "true",  // Generate only interfaces (no implementation classes)
        "reactive" to "true"  // Enable reactive programming support (e.g., Spring WebFlux)
    ))
}

