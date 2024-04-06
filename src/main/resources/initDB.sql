CREATE SCHEMA `bookshelf`;

CREATE TABLE `bookshelf`.`book` (
                                    `id` INT NOT NULL AUTO_INCREMENT,
                                    `title` VARCHAR(255) NOT NULL,
                                    `description` TEXT NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE);

CREATE TABLE `bookshelf`.`author` (
                                      `id` INT NOT NULL AUTO_INCREMENT,
                                      `first_name` VARCHAR(45) NOT NULL,
                                      `middle_name` VARCHAR(45) NULL,
                                      `last_name` VARCHAR(45) NOT NULL,
                                      `date_of_birth` DATETIME NOT NULL,
                                      `date_of_death` DATETIME NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE INDEX `first_name_UNIQUE` (`first_name` ASC) VISIBLE,
                                      UNIQUE INDEX `last_name_UNIQUE` (`last_name` ASC) VISIBLE,
                                      UNIQUE INDEX `date_of_birth_UNIQUE` (`date_of_birth` ASC) VISIBLE);

CREATE TABLE `bookshelf`.`book_author_relation` (
                                                    `id_book` INT NOT NULL,
                                                    `id_author` INT NOT NULL,
                                                    PRIMARY KEY (`id_book`, `id_author`),
                                                    UNIQUE INDEX `id_author_book_UNIQUE` (`id_author`, `id_book` ASC) VISIBLE);
