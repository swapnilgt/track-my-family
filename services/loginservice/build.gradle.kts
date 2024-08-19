import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
}

group = "com.trackmyfamily"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.security:spring-security-web")
    implementation(project(":commons"))
    aspect(project(":commons"))
    runtimeOnly("org.postgresql:postgresql")
}
