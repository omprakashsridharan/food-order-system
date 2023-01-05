plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.kafka:spring-kafka:3.0.1")
    implementation("io.confluent:kafka-avro-serializer:7.3.1")
    implementation("org.apache.avro:avro:1.11.1")

}