# Clients schema

# --- !Ups

CREATE TABLE clients (
    id int(20) NOT NULL AUTO_INCREMENT,
    dni varchar(255)  NULL,
    name varchar(255) NULL,
    last_name varchar(255) NULL,
    phone varchar(255) NULL,
    email varchar(255) NULL,
    status varchar(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE hibernate_sequences(
	sequence_name varchar(50) NOT NULL,
	next_val bigint(20) NULL,
	PRIMARY KEY (sequence_name)
);

# --- !Downs

DROP TABLE clients;
DROP TABLE sequence;