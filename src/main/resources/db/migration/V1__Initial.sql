/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Initial database structure and data.
 */

/*
 * Structure
 */


CREATE TABLE supermarkets
(
    id      INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ar_name VARCHAR(255)        NOT NULL,
    en_name VARCHAR(255)        NOT NULL,
    address VARCHAR(255)        NOT NULL,
    image   VARCHAR(255)        NOT NULL,
    active  BOOLEAN             NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT 1,
  `expired` bit(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `UQ_Account_Username` UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_roles` (
  `userId` bigint(20) unsigned NOT NULL,
  `roleId` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`userId`, `roleId`),
  CONSTRAINT `FK_UserRole_UserId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_UserRole_RoleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
