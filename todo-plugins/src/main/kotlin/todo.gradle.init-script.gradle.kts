import org.gradle.kotlin.dsl.kotlin
import java.io.ByteArrayOutputStream

plugins {
    kotlin("jvm")
}
val checkDockerContainer by tasks.registering(Exec::class) {
    commandLine("docker", "ps", "--filter", "name=mysql-db", "--format", "{{.Names}}")
    standardOutput = ByteArrayOutputStream()
    errorOutput = System.err
    isIgnoreExitValue = true
}

fun execudeCommandLine(
    commands: List<String>,
    errorStream: ByteArrayOutputStream,
) {
    exec {
        commandLine(commands)
        standardOutput = ByteArrayOutputStream()
        errorOutput = errorStream
        isIgnoreExitValue = true
    }

    val error = errorStream.toString().trim()

    if (error.isEmpty()) {
        println("Command executed successfully!")
    } else if (error.lines().any { it.contains("WARNING", ignoreCase = true) }) {
        println("WARNING: $error")
    } else {
        println("Command failed!")
        println("ERROR: $error")
    }
}

fun getEnv(key: String): String {
    val envFile = File("${projectDir.parent}/.env")
    val envVars = envFile.readLines()
        .filter { it.contains("=") }
        .map { it.split("=") }
        .associate { it[0].trim() to it[1].trim() }
    return envVars[key] ?: ""
}

tasks.register("checkAndRunInit") {
    dependsOn("checkDockerContainer")
    doLast {
        val isContains = (checkDockerContainer.get().standardOutput as ByteArrayOutputStream)
            .toString().trim()
            .contains("mysql-db")

        if (isContains) {
            println("Docker is running!")
            println("Docker-compose crating database scheme.")

            val errorStream = ByteArrayOutputStream()

            println("Copy create script file to docker-compose.")
            execudeCommandLine(
                commands = listOf(
                    "docker",
                    "cp",
                    "${projectDir}/src/main/resources/schema.sql",
                    "mysql-db:/create.sql"
                ),
                errorStream = errorStream
            )

            println("Execute create script.")
            execudeCommandLine(
                commands = listOf(
                    "docker",
                    "exec",
                    "-i",
                    "mysql-db",
                    "mysql",
                    "-u${getEnv("DATABASE_USERNAME")}",
                    "-p${getEnv("DATABASE_PASSWORD")}",
                    "mydatabase",
                    "-e",
                    "source /create.sql"
                ),
                errorStream = errorStream
            )
        } else {
            println("Docker isn't running!")
        }
    }
}

tasks.named("bootRun"){
    dependsOn("checkAndRunInit")
}