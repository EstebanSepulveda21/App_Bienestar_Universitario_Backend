-- DDL
CREATE TABLE Persona (id SERIAL NOT NULL, name varchar(255) NOT NULL,
lastName varchar(255) NOT NULL, email varchar(255) NOT NULL,
userType varchar(255) NOT NULL,
password varchar(255) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Reservas ("fecha-hora" date NOT NULL, "Servicio ofertadoid" int4 NOT NULL, 
PersonaId int4 NOT NULL, PRIMARY KEY ("fecha-hora", "Servicio ofertadoid"));
CREATE TABLE Sede (id SERIAL NOT NULL, name varchar(255) NOT NULL,
address varchar(255) NOT NULL, PRIMARY KEY (id));
CREATE TABLE ServicioOfertado (id SERIAL NOT NULL, Sedeid int4 NOT NULL,
name varchar(255) NOT NULL, description varchar(255) NOT NULL,
capacity int4 NOT NULL, PRIMARY KEY (id));
ALTER TABLE Reservas ADD CONSTRAINT FKReservas40039 
FOREIGN KEY ("Servicio ofertadoid") REFERENCES ServicioOfertado (id);
ALTER TABLE Reservas ADD CONSTRAINT FKReservas337752 
FOREIGN KEY (PersonaId) REFERENCES Persona (id);
ALTER TABLE ServicioOfertado ADD CONSTRAINT FKServicioOf798795 
FOREIGN KEY (Sedeid) REFERENCES Sede (id);
-- DROP

ALTER TABLE Reservas DROP CONSTRAINT FKReservas40039;
ALTER TABLE Reservas DROP CONSTRAINT FKReservas337752;
ALTER TABLE ServicioOfertado DROP CONSTRAINT FKServicioOf798795;
DROP TABLE IF EXISTS Persona CASCADE;
DROP TABLE IF EXISTS Reservas CASCADE;
DROP TABLE IF EXISTS Sede CASCADE;
DROP TABLE IF EXISTS ServicioOfertado CASCADE;

-- DML

-- Select
SELECT id, name, lastName, email, userType FROM Persona;
SELECT "fecha-hora", "Servicio ofertadoid", PersonaId FROM Reservas;
SELECT id, name, address FROM Sede;
SELECT id, Sedeid, name, description, capacity FROM ServicioOfertado;

-- Insert
INSERT INTO Persona(id, name, lastName, email, userType) VALUES (?, ?, ?, ?, ?);
INSERT INTO Reservas("fecha-hora", "Servicio ofertadoid", PersonaId) VALUES (?, ?, ?);
INSERT INTO Sede(id, name, address) VALUES (?, ?, ?);
INSERT INTO ServicioOfertado(id, Sedeid, name, description, capacity) VALUES (?, ?, ?, ?, ?);

-- Update
UPDATE Persona SET name = ?, lastName = ?, email = ?, userType = ? WHERE id = ?;
UPDATE Reservas SET PersonaId = ? WHERE "fecha-hora" = ? AND "Servicio ofertadoid" = ?;
UPDATE Sede SET name = ?, address = ? WHERE id = ?;
UPDATE ServicioOfertado SET Sedeid = ?, name = ?, description = ?, capacity = ? WHERE id = ?;


-- Delete
DELETE FROM Persona WHERE id = ?;
DELETE FROM Reservas WHERE "fecha-hora" = ? AND "Servicio ofertadoid" = ?;
DELETE FROM Sede WHERE id = ?;
DELETE FROM ServicioOfertado WHERE id = ?;

