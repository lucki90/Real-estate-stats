--liquibase formatted sql
--changeset luckit:4

ALTER TABLE real_estate_data
    ADD INDEX (real_estate_id);
ALTER TABLE real_estate_data
    ADD INDEX (type);
ALTER TABLE real_estate_data
    ADD INDEX (size);
ALTER TABLE real_estate
    ADD INDEX (region);
ALTER TABLE real_estate
    ADD INDEX (report_date);
