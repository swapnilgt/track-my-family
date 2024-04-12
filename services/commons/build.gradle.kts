plugins {
    java
}

group = "com.trackmyfamily"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.4"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.security:spring-security-web")
    implementation("com.google.firebase:firebase-admin:9.2.0")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}