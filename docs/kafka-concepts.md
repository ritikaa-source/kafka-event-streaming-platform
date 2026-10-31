# Kafka Concepts

- Topic: durable logical event stream.
- Partition: ordered append-only log; ordering is per partition.
- Key: controls partition placement; this project uses `userId`.
- Consumer group: shares partition work among members.
- Offset: consumer position per partition/group.
- Lag: latest available position minus consumer progress.
- Retention: deletes old data according to policy.
- Compaction: retains latest record for a key.
- KRaft: controller quorum architecture replacing ZooKeeper.
