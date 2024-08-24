plugins {
    id("org.openapi.generator")
}

tasks.named("compileKotlin").configure {
    dependsOn(tasks.named("openApiGenerate"))
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/todo-api/src/main/resources/todo-api.yaml")
    outputDir.set("$rootDir/todo-api/build/generated")
    apiPackage.set("com.todo.api")
    modelPackage.set("com.todo.model")
    skipValidateSpec.set(true)
    validateSpec.set(false)
    configOptions.set(mapOf(
        "dateLibrary" to "java8",
        "useSpringBoot3" to "true",
        "interfaceOnly" to "true",
        "reactive" to "true"
    ))
}
