USE habronat;

CREATE TABLE `adverts_metadata` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `url` CHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY `adverts_metadata_pk` (`id`),
  INDEX `url_idx` (`url`)
);

CREATE TABLE `real_estate_adverts` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `advert_metadata_fk` INT(10) NOT NULL,
  PRIMARY KEY `real_estate_adverts_pk` (`id`),
  FOREIGN KEY `adverts_metadata_fk` (`advert_metadata_fk`) REFERENCES `adverts_metadata` (`id`)
);