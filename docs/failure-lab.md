# Failure Lab

1. Consumer crash: stop analytics, produce events, restart and inspect offsets.
2. Duplicate: send the same event ID twice and verify one DB row.
3. Slow consumer: add delay and observe lag.
4. Hot partition: use one key repeatedly and observe partition skew.
5. DB outage:
```powershell
docker stop kafka-event-postgres
docker start kafka-event-postgres
```
6. Broker failure: use a separate 3-broker KRaft lab with RF=3, min ISR=2; stop a broker and observe leader/ISR behavior.
7. Rebalance storm: repeatedly start/stop consumers and discuss heartbeat and `max.poll.interval.ms`.
