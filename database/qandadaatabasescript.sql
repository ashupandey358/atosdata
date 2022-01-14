-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema minorproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema minorproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `minorproject` DEFAULT CHARACTER SET utf8 ;
USE `minorproject` ;

-- -----------------------------------------------------
-- Table `minorproject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `minorproject`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `pannumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `minorproject`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `minorproject`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `questions` VARCHAR(1000) NOT NULL,
  `detailedquestion` VARCHAR(10000) NOT NULL,
  `datetime` VARCHAR(45) NOT NULL,
  `userid` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_fk_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `minorproject`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `minorproject`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `minorproject`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `answer` VARCHAR(10000) NOT NULL,
  `questionID` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `question_fk_idx` (`questionID` ASC) VISIBLE,
  CONSTRAINT `question_fk`
    FOREIGN KEY (`questionID`)
    REFERENCES `minorproject`.`question` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
