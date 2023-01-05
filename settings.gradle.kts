rootProject.name = "food-ordering-system"

include(
    "order-service",
    "order-service:order-domain:order-domain-core",
    "order-service:order-domain:order-application-service",
    "order-service:order-data-access",
    "order-service:order-application",
    "order-service:order-container",
    "order-service:order-messaging",
    "common:common-domain",
    "infrastructure:kafka:kafka-producer",
    "infrastructure:kafka:kafka-consumer",
    "infrastructure:kafka:kafka-model",
    "infrastructure:kafka:kafka-config-data",
    "infrastructure"
)