--liquibase formatted sql
--changeset luckit:3

ALTER TABLE real_estate_data
    ADD CONSTRAINT real_estate_data_real_estate_id
        FOREIGN KEY (real_estate_id) REFERENCES real_estate (id);