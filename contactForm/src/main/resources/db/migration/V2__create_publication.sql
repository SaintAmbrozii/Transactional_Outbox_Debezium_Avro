CREATE TABLE IF NOT EXISTS debezium_heartbeat(
                                              id INTEGER PRIMARY KEY,
                                              updated_at TIMESTAMP NOT NULL
);

CREATE PUBLICATION contacts_outbox FOR TABLE contacts,debezium_heartbeat;