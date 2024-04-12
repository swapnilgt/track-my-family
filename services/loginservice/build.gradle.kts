import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
}

group = "com.trackmyfamily"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":commons"))
    aspect(project(":commons"))
    runtimeOnly("org.postgresql:postgresql")
}
