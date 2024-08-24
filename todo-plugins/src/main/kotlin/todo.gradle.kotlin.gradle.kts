plugins {
    kotlin("jvm")
    jacoco
}

val jvmTargetVersion = JavaVersion.VERSION_17

java {
    sourceCompatibility = jvmTargetVersion
    targetCompatibility = jvmTargetVersion
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<JacocoReport>("jacocoTestReport") {
    dependsOn(tasks.withType<Test>())
    reports {
        xml.required.set(true)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
