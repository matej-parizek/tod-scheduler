import org.gradle.api.tasks.Exec
import java.io.ByteArrayOutputStream

subprojects {
    repositories {
        mavenCentral()
    }
}

val checkDockerContainer by tasks.registering(Exec::class) {
    commandLine("docker", "ps", "--filter", "name=mysql-db", "--format", "{{.Names}}")
    standardOutput = ByteArrayOutputStream()
    errorOutput = System.err
    isIgnoreExitValue = true
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
        }
        else{
            println("Docker isn't running!")
        }
    }
}