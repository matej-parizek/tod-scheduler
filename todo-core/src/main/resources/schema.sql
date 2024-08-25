CREATE TABLE TASK (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       description VARCHAR(255) NOT NULL ,
                       label VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
