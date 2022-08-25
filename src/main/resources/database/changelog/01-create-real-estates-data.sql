--liquibase formatted sql
--changeset luckit:1

CREATE TABLE real_estate_data
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    real_estate_id BIGINT,
    type           VARCHAR(255)   NOT NULL,
    price          DECIMAL(10, 2) NOT NULL,
    description    VARCHAR(255)   NOT NULL,
    size           VARCHAR(255)   NOT NULL,
    rooms          SMALLINT
);