CREATE TABLE contacts(

   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name  varchar(36),
    phone  varchar(36)
);

CREATE PUBLICATION contacts_outbox FOR TABLE contacts;

SELECT pg_create_logical_replication_slot('postgres_debezium', 'pgoutput');