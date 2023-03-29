import org.gradle.api.tasks.testing.logging.TestLogEvent.*

val KOTEST_VERSION = "5.5.0"

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compileOnly("com.h2database:h2")

    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

    testImplementation("org.springframework.boot:spring-boot-starter-test"){
        exclude(module = "mockito-core")
    }
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:${KOTEST_VERSION}")
    testImplementation("io.kotest:kotest-assertions-core:${KOTEST_VERSION}")
    testImplementation("io.mockk:mockk:1.13.0")
    testImplementation("com.ninja-squad:springmockk:4.0.0")
    testRuntimeOnly("com.h2database:h2")
}

tasks.getByName<Test>("test") {
    systemProperty("spring.profiles.active", "test")
    useJUnitPlatform()
    testLogging {
        events(PASSED, FAILED, STANDARD_ERROR, SKIPPED)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}
