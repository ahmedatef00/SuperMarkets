CREATE TABLE supermarkets
(
    id      INT(11) PRIMARY KEY,
    ar_name VARCHAR(255) NOT NULL,
    en_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    image   VARCHAR(255) NOT NULL,
    active  ENUM ('0','1') NOT NULL
);

ALTER TABLE `supermarkets` CHANGE `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `supermarkets` CHANGE `active` `active` BOOLEAN NOT NULL;
