-- CREATE database `fashion`
-- DEFAULT CHARACTER SET utf8;

use `fashion`;


CREATE TABLE `fashion`.`genders` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `fashion`.`users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `dob` DATE NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(40) NOT NULL,
    `image` VARCHAR(50) NULL,
    `gender_id` TINYINT NOT NULL,
    `create_date` DATETIME NOT NULL default current_timestamp,
    `updated_date` DATETIME NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`gender_id`)
        REFERENCES `fashion`.`genders` (`id`)
);

CREATE TABLE `fashion`.`roles` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `fashion`.`role_status` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);


CREATE TABLE `fashion`.`user_roles` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL,
    `role_id` TINYINT NOT NULL,
    `status_id` TINYINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`status_id`)
        REFERENCES `fashion`.`role_status` (`id`),
    FOREIGN KEY (`user_id`)
        REFERENCES `fashion`.`users` (`id`),
    FOREIGN KEY (`role_id`)
        REFERENCES `fashion`.`roles` (`id`)
);

-- MEXRI EDW OLA KALA -- 

CREATE TABLE `fashion`.`pay_methods` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);


CREATE TABLE `fashion`.`plans` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    `price` DECIMAL(5 , 2 ) NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `fashion`.`subscription_status` (
    `id` TINYINT NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `fashion`.`subscriptions` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `pay_method_id` TINYINT NOT NULL,
    `plan_id` TINYINT NOT NULL,
    `start_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `end_date` DATETIME NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`pay_method_id`)
        REFERENCES `fashion`.`pay_methods` (`id`),
    FOREIGN KEY (`plan_id`)
        REFERENCES `fashion`.`plans` (`id`)
);


CREATE TABLE `fashion`.`user_subscriptions` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT,
    `subscriptions_id` INT,
    `status_id` TINYINT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`)
        REFERENCES `fashion`.`users` (`id`),
    FOREIGN KEY (`status_id`)
        REFERENCES `fashion`.`subscription_status` (`id`),
    FOREIGN KEY (`subscriptions_id`)
        REFERENCES `fashion`.`subscriptions` (`id`)
);



CREATE TABLE `brands` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `descr` text NULL,
    `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `image_path` VARCHAR(100) NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`)
        REFERENCES `fashion`.`users` (`id`)
);


CREATE TABLE `products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `brand_id` INT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `descr` TEXT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`brand_id`)
        REFERENCES `fashion`.`brands` (`id`)
);



CREATE TABLE `product_images` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `product_id` INT,
    `image_path` VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`product_id`)
        REFERENCES `fashion`.`products` (`id`)
);







