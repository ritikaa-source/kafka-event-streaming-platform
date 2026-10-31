# Security, Observability, HA and DR

## Security
- TLS
- SASL/authentication
- ACLs
- least privilege
- secrets management
- auditability
- network controls

## Observability
Monitor:
- consumer lag
- throughput
- producer/consumer errors
- retry/DLT volume
- broker CPU/memory/disk/network
- under-replicated partitions
- ISR changes
- controller health
- rebalances

## Capacity
Start with events/sec, peak rate, event size, retention, compression, RF and required parallelism. Validate disk and network capacity.

## DR
Define RPO, RTO, failover, data residency, replication, offset recovery and duplicate handling.

HA and DR are different concerns.
