plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation(project(":order-service:order-domain:order-domain-core"))
    implementation(project(":common:common-domain"))
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.1")
    implementation("org.springframework:spring-tx:6.0.3")
}