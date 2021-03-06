/*****************************************************
** Create database parking
******************************************************
** Script date of creation: 10/16/2018 22:39:18
** Author: arturo.04@gmail.com
** Generated by Toad Edge
******************************************************
** Script generated from parking_2018_10_16_22_38_46 snapshot
** Snapshot date of creation: 1539747535187
** Database user: root
** Source Database version: MYSQL 5.7.23
*****************************************************/

SET @ORIGINAL_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS,
    FOREIGN_KEY_CHECKS = 0;
SET @ORIGINAL_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @ORIGINAL_SQL_MODE = @@SQL_MODE,
    SQL_MODE =
       'ALLOW_INVALID_DATES,NO_AUTO_VALUE_ON_ZERO,NO_AUTO_CREATE_USER';

create database parking;       

USE parking;

CREATE TABLE user
(
   username    VARCHAR(45)
                 CHARACTER SET latin1
                 COLLATE latin1_swedish_ci
                 NOT NULL,
   password    VARCHAR(45)
                 CHARACTER SET latin1
                 COLLATE latin1_swedish_ci
                 NOT NULL,
   enabled     TINYINT(4) NOT NULL DEFAULT 1,
   PRIMARY KEY(username)
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

CREATE TABLE marca
(
   `idMarca`      INT(11) NOT NULL AUTO_INCREMENT,
   marca          VARCHAR(50)
                    CHARACTER SET latin1
                    COLLATE latin1_swedish_ci
                    NOT NULL,
   `fechaAlta`    DATE NULL,
   PRIMARY KEY(`idMarca`)
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

CREATE TABLE modelo
(
   `idModelo`     INT(11) NOT NULL AUTO_INCREMENT,
   modelo         VARCHAR(50)
                    CHARACTER SET latin1
                    COLLATE latin1_swedish_ci
                    NOT NULL,
   anio           VARCHAR(5)
                    CHARACTER SET latin1
                    COLLATE latin1_swedish_ci
                    NOT NULL,
   `fechaAlta`    DATE NULL,
   `idMarca`      INT(11) NOT NULL,
   CONSTRAINT modelo_ibfk_1 FOREIGN KEY(`idMarca`)
      REFERENCES marca (`idMarca`) ON UPDATE RESTRICT ON DELETE RESTRICT,
   PRIMARY KEY(`idModelo`),
   INDEX `idMarca` (`idMarca`) USING BTREE
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

CREATE TABLE vehiculo
(
   `idVehiculo`      INT(11) NOT NULL AUTO_INCREMENT,
   `idModelo`        INT(11) NOT NULL,
   `noPlaca`         VARCHAR(20)
                       CHARACTER SET latin1
                       COLLATE latin1_swedish_ci
                       NOT NULL,
   `tipoVehiculo`    VARCHAR(2)
                       CHARACTER SET latin1
                       COLLATE latin1_swedish_ci
                       NOT NULL,
   `fechaAlta`       DATE NOT NULL,
   CONSTRAINT vehiculo_ibfk_1 FOREIGN KEY(`idModelo`)
      REFERENCES modelo (`idModelo`) ON UPDATE RESTRICT ON DELETE RESTRICT,
   PRIMARY KEY(`idVehiculo`),
   INDEX `idModelo` (`idModelo`) USING BTREE
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

CREATE TABLE registro
(
   `idRegistro`      INT(11) NOT NULL AUTO_INCREMENT,
   `fechaEntrada`    DATE NOT NULL,
   `fechaSalida`     DATE NULL,
   `horaEntrada`     VARCHAR(10)
                       CHARACTER SET latin1
                       COLLATE latin1_swedish_ci
                       NOT NULL,
   `horaSalida`      VARCHAR(10)
                       CHARACTER SET latin1
                       COLLATE latin1_swedish_ci
                       NULL,
   status            VARCHAR(2)
                       CHARACTER SET latin1
                       COLLATE latin1_swedish_ci
                       NULL,
   `idVehiculo`      INT(11) NOT NULL,
   CONSTRAINT registro_ibfk_1 FOREIGN KEY(`idVehiculo`)
      REFERENCES vehiculo (`idVehiculo`)
         ON UPDATE RESTRICT
         ON DELETE RESTRICT,
   PRIMARY KEY(`idRegistro`),
   INDEX `idVehiculo` (`idVehiculo`) USING BTREE
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

CREATE TABLE user_role
(
   user_role_id    INT(11) NOT NULL AUTO_INCREMENT,
   username        VARCHAR(45)
                     CHARACTER SET latin1
                     COLLATE latin1_swedish_ci
                     NOT NULL,
   role            VARCHAR(45)
                     CHARACTER SET latin1
                     COLLATE latin1_swedish_ci
                     NOT NULL,
   PRIMARY KEY(user_role_id),
   UNIQUE KEY uni_username_role(role, username),
   CONSTRAINT fk_username FOREIGN KEY(username)
      REFERENCES user (username) ON UPDATE RESTRICT ON DELETE RESTRICT,
   INDEX fk_username_idx (username) USING BTREE
)
ENGINE INNODB
COLLATE 'latin1_swedish_ci'
ROW_FORMAT DEFAULT;

SET FOREIGN_KEY_CHECKS = @ORIGINAL_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @ORIGINAL_UNIQUE_CHECKS;
SET SQL_MODE = @ORIGINAL_SQL_MODE;