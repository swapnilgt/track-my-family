plugins {
    java
}

group = "com.trackmyfamily"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.4"))
    implementation("org.springframework.boot:spring-boot")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}