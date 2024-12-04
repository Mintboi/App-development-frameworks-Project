DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS household;

CREATE TABLE household (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255),
                           address VARCHAR(255)
);

CREATE TABLE pet (
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     name VARCHAR(255),
                     type VARCHAR(255),
                     age INTEGER,
                     household_id BIGINT,
                     CONSTRAINT fk_household FOREIGN KEY (household_id) REFERENCES household(id)
);
