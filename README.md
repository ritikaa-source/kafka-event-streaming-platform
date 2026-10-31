# Real-Time Digital Experience & Event Streaming Platform

Complete hands-on Kafka project for Technical Lead / Technical Architect interview preparation.

## Stack
- Java 21
- Spring Boot 4.0.1
- Spring Kafka 4.0.1
- Apache Kafka 4.0.1 (KRaft)
- PostgreSQL 17
- Kafka UI
- Maven
- Docker Compose

## Architecture
Client -> Event Producer -> Kafka `digital.events`

`digital.events` has 4 partitions and uses `userId` as the partition key.

Consumer groups:
- `analytics-group` -> PostgreSQL + idempotency
- `monitoring-group` -> operational monitoring

Kafka Streams creates real-time per-user event counts.

## Start infrastructure
```powershell
cd docker
docker compose up -d
docker ps
```

Kafka: localhost:9092
PostgreSQL: localhost:5433
Kafka UI: http://localhost:8080

## Run services
```powershell
cd event-producer-service
mvn spring-boot:run
```
Producer port: 8081.

```powershell
cd analytics-service
mvn spring-boot:run
```

```powershell
cd monitoring-service
mvn spring-boot:run
```

```powershell
cd kafka-streams-service
mvn spring-boot:run
```

## Send event
```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8081/api/v1/events" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{
    "eventId": "E10001",
    "eventType": "VIDEO_STARTED",
    "userId": "U101",
    "contentId": "C500",
    "deviceId": "D900",
    "timestamp": "2026-09-17T10:30:00Z"
  }'
```

Expected:
`Event accepted: E10001`

## Consumer groups
```powershell
docker exec -it kafka-event-platform /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

```powershell
docker exec -it kafka-event-platform /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group analytics-group
```

## Learning order
1. Producer/topic/partition
2. Key and ordering
3. Consumer groups
4. Offsets and lag
5. Idempotency
6. Retry/DLT
7. Kafka Streams
8. Schema Registry
9. Outbox and CDC/Debezium
10. Security
11. Observability
12. HA/ISR and broker failure
13. Capacity planning
14. Multi-region/DR
15. Architect interview walkthrough

The code provides the runnable core. The docs cover production patterns that require additional infrastructure.
