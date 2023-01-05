package com.food.ordering.system.kafka.config.data

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
data class KafkaConsumerConfigData(
    private val keyDeserializer: String,
    private val valueDeserializer: String,
    private val autoOffsetReset: String,
    private val specificAvroReaderKey: String,
    private val specificAvroReader: String,
    private val batchListener: Boolean,
    private val autoStartup: Boolean,
    private val concurrencyLevel: Int,
    private val sessionTimeoutMs: Int,
    private val heartbeatIntervalMs: Int,
    private val maxPollIntervalMs: Int,
    private val pollTimeoutMs: Long,
    private val maxPollRecords: Int,
    private val maxPartitionFetchBytesDefault: Int,
    private val maxPartitionFetchBytesBoostFactor: Int,
)
