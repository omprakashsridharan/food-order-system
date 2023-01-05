package com.food.ordering.system.kafka.config.data

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "kafka-producer-config")
data class KafkaProducerConfigData(
    private val keySerializerClass: String,
    private val valueSerializerClass: String,
    private val compressionType: String,
    private val acks: String,
    private val batchSize: Int,
    private val batchSizeBoostFactor: Int,
    private val lingerMs: Int,
    private val requestTimeoutMs: Int,
    private val retryCount: Int,
)