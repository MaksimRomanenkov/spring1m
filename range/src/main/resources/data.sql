DROP TABLE IF EXISTS ids;

CREATE TABLE ids
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    start_id     bigint NOT NULL,
    end_id       bigint NOT NULL,
    service_name VARCHAR(250) DEFAULT NULL
);
