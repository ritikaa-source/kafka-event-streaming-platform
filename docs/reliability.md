# Reliability

## Delivery
At-most-once can lose records.
At-least-once can duplicate records.
Exactly-once is scoped to Kafka transaction workflows; external side effects need their own consistency strategy.

## Producer
This project uses:
- `acks=all`
- `enable.idempotence=true`
- retries

## Consumer idempotency
Analytics uses `event_id` as a primary key and `ON CONFLICT DO NOTHING`.

## Retry / DLT
Recommended production pattern:

```text
main -> retry-1m -> retry-5m -> retry-30m -> DLT
```

Keep original topic/partition/offset, event ID, failure reason and timestamps in DLT diagnostics.

Ordering requirements must be considered before allowing later records to continue past a failed record.
