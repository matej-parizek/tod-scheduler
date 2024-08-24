plugins {
    id("todo.gradle.kotlin")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
    kotlin("plugin.spring")
    id("com.gorylenko.gradle-git-properties")
}

springBoot {
    buildInfo()
}
tasks.getByName<Jar>("jar") {
    enabled = false
}

gitProperties {
    failOnNoGitDirectory = false
}

extra["kotest-extensions-spring.version"] = "1.1.3"
extra["snakeyaml.version"] = "2.2"
extra["spring-boot.version"] = "3.1.4"
extra["springmockk.version"] = "4.0.2"

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${property("spring-boot.version")}")
    }
    dependencies {
        dependency("com.ninja-squad:springmockk:${property("springmockk.version")}")
        dependency("io.kotest.extensions:kotest-extensions-spring:${property("kotest-extensions-spring.version")}")
    }
}
