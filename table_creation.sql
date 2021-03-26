CREATE TABLE `vehicle`.`ships`
(
    `type`               ENUM ('CARGO','FISHING')                NOT NULL,
    `model`              VARCHAR(30)                             NOT NULL,
    `engine`             ENUM ('ELECTRIC','INTERNAL_COMBUSTION') NOT NULL,
    `powerHP`            INT                                     NOT NULL,
    `topSpeed`           INT                                     NOT NULL,
    `registrationNumber` VARCHAR                                 NOT NULL,
    PRIMARY KEY (`registrationNumber`)
) ENGINE = InnoDB;
