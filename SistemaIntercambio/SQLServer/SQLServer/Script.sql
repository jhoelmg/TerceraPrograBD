USE master;
GO
CREATE DATABASE Example;
GO
USE Example;
GO
CREATE TABLE Person
(
	personID int,
	name varchar(255),
	lastName varchar(255),
	country varchar(255),
	address varchar(255)
);
GO
CREATE PROCEDURE toUpperCaseNameAndLastName
AS 
	UPDATE Person SET name = upper(name);
	UPDATE Person SET lastName = upper(lastName);
GO
INSERT INTO Person VALUES(1, 'Juan', 'Perez', 'Costa Rica', 'San Jose, Moravia');
INSERT INTO Person VALUES(2, 'Pablo', 'Solis', 'Costa Rica', 'Cartago, Tres Rios');
INSERT INTO Person VALUES(3, 'Maria', 'Alfaro', 'Costa Rica', 'Heredia, Santo Domingo');
INSERT INTO Person VALUES(4, 'Andrea', 'Alvarado', 'Costa Rica', 'Alajuela, Naranjo');