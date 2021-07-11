CREATE TABLE supermarkets
(
    id      INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ar_name VARCHAR(255) NOT NULL,
    en_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    image   VARCHAR(255) NOT NULL,
    active  BOOLEAN NOT NULL
);

