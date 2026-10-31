# Transactional Outbox, Kafka Connect and CDC

## Outbox

```text
DB transaction
  |-- business data
  |-- outbox_event
          |
          v
   outbox publisher
          |
          v
        Kafka
```

It solves the database/event dual-write consistency problem. It does not remove duplicate delivery.

## CDC / Debezium

CDC captures database changes and publishes them to Kafka.

CDC is useful for data integration and modernization. A row-level DB change is not automatically a business event.

## Kafka Connect

Connect provides source/sink integration through workers, connectors and tasks. Keep domain rules in services/stream processors.
