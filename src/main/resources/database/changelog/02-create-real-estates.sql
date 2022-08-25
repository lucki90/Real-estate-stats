--liquibase formatted sql
--changeset luckit:2

CREATE TABLE real_estate
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    region      VARCHAR(255) NOT NULL,
    report_date TIMESTAMP
);
