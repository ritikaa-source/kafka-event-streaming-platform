# Architecture

```text
Clients
  |
  v
Event Producer API :8081
  |
  | key = userId
  v
Kafka: digital.events
  |        |        |
  |        |        +--> Kafka Streams --> digital.user.event.counts
  |        |
  |        +--> monitoring-group
  |
  +----------> analytics-group --> PostgreSQL
```

Partitions provide scalability and ordering boundaries.
Replication provides fault tolerance.

Production evolution:
- 3+ brokers
- RF=3
- min.insync.replicas=2
- TLS/SASL
- ACLs
- Schema Registry
- Kafka Connect
- metrics/logging
- multi-AZ and DR
