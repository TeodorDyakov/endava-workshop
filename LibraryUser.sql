CREATE TABLE `Library`.`User`
(
    `first_name` VARCHAR(100) NOT NULL,
    `last_name`  VARCHAR(100) NOT NULL,
    `email`      VARCHAR(320) NOT NULL,
    `EGN`        CHAR(10)     NOT NULL,
    `city`       VARCHAR(100) NOT NULL,
    `address`    VARCHAR(500) NOT NULL,
    `status`     ENUM('Active','Inactive') NOT NULL,
    PRIMARY KEY (`EGN`),
    UNIQUE (`email`)
) ENGINE = InnoDB;
