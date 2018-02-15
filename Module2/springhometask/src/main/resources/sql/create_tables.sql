-- -----------------------------------------------------
-- Schema spring-hometask
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spring-hometask` DEFAULT CHARACTER SET utf8 ;
USE `spring-hometask` ;
-- -----------------------------------------------------
-- Table `spring-hometask`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-hometask`.`User` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring-hometask`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-hometask`.`Event` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `ticketPrice` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring-hometask`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-hometask`.`Ticket` (
  `ticketId` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BIGINT NOT NULL,
  `eventId` BIGINT NOT NULL,
  `Place` INT NOT NULL,
  `Category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ticketId`, `userId`, `eventId`),
  INDEX `fk_Ticket_User_idx` (`userId` ASC),
  INDEX `fk_Ticket_Event1_idx` (`eventId` ASC),
  CONSTRAINT `fk_Ticket_User`
    FOREIGN KEY (`userId`)
    REFERENCES `spring-hometask`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ticket_Event1`
    FOREIGN KEY (`eventId`)
    REFERENCES `spring-hometask`.`Event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring-hometask`.`UserAccount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring-hometask`.`UserAccount` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ammountOfPrepaidMoney` INT NOT NULL,
  `userId` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `userId`),
  INDEX `fk_UserAccount_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_UserAccount_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `spring-hometask`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
