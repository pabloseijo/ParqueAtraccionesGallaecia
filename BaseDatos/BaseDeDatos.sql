--Script de creación de una base de datos
--Autores: Miguel Leal, Pablo Lobato, Manuel Estévez, Pablo Seijo
--Fecha: 12/abr/2023

--Creación de la base de datos
CREATE DATABASE ParqueAtraccionesGallaecia;

--Conexión a la base de datos

--Creación de la tabla Espectaculos
CREATE TABLE Espectaculos (
    ID SERIAL PRIMARY KEY,
    Nombre VARCHAR(50),
    Sesion VARCHAR(50),
    HorarioInicio TIME,
    HorarioFin TIME,
    Tematica VARCHAR(50),
    Descripcion VARCHAR(100),
    Ubicacion VARCHAR(50)
);

--Creación de la tabla Visitantes
CREATE TABLE Visitantes (
    DNI CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    correoElectronico VARCHAR(50),
    fechaNacimiento DATE
);

--Creación de la tabla Hosteleria
CREATE TABLE Hosteleria (
    codigoRegistro SERIAL PRIMARY KEY,
    Nombre VARCHAR(50),
    Aforo INTEGER,
    Ubicaciones VARCHAR(50),
    HoraApertura TIME,
    HoraCierre TIME,
    Recaudacion FLOAT
);

--Creación de la tabla Atracciones
CREATE TABLE Atracciones (
    NumeroRegistro SERIAL PRIMARY KEY,
    Nombre VARCHAR(50),
    Aforo INTEGER,
    AlturaMin INTEGER,
    CosteMantenimiento INTEGER,
    EnReparacion BOOLEAN,
    Ubicaciones VARCHAR(50),
    Descripcion VARCHAR(200)
);

--Creación de la tabla Ir
CREATE TABLE Ir (
    FechaVisita DATE,
    Visitante CHAR(9),
    Atraccion INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Atraccion) REFERENCES Atracciones (NumeroRegistro) ON DELETE CASCADE ON UPDATE CASCADE
);

--Creación de la tabla Comer
CREATE TABLE Comer (
    FechaVisita DATE,
    Visitante CHAR(9),
    Establecimiento INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Establecimiento) REFERENCES Hosteleria (codigoRegistro) ON DELETE CASCADE ON UPDATE CASCADE
);

--Creación de la tabla Asistir
CREATE TABLE Asistir (
    FechaVisita DATE,
    Visitante CHAR(9),
    Espectaculo INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Espectaculo) REFERENCES Espectaculos (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE TrabajadoresEspectaculo(
    DNI CHAR(9) PRIMARY KEY not null,
    Nombre VARCHAR (50),
    Direccion VARCHAR(50),
    Salario FLOAT,
    Telefono INTEGER,
    fechaContratacion DATE,
    fechaNacimiento DATE,
    Formacion VARCHAR (50), 
    Espectaculo INTEGER,
    Edad INTEGER GENERATED ALWAYS AS (CAST (strftime('%Y', 'now') - strftime('%Y', FechaNacimiento ) - (strftime('%m-%d', 'now') < strftime('%m-%d', FechaNacimiento ))) AS INTEGER),
    tiempo_trabajado INTEGER GENERATED ALWAYS AS (CAST (strftime('%Y', 'now') - strftime('%Y', fechaContratacion ) - (strftime('%m-%d', 'now') < strftime('%m-%d', fechaContratacion ))) AS INTEGER),
    FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE

CREATE TABLE TrabajadoresAdministracion(
    DNI CHAR(9) PRIMARY KEY not null,
    Nombre VARCHAR (50),
    Direccion VARCHAR(50),
    Salario FLOAT,
    Telefono INTEGER,
    fechaContratacion DATE,
    fechaNacimiento DATE,
    Formacion VARCHAR (50), 
    Espectaculo INTEGER,
    Atraccion INTEGER,
    Edad INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaNacimiento)) VIRTUAL,
    tiempo_trabajado INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaContratacion)) VIRTUAL,
    FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE TrabajadoresMantenimiento(
    DNI CHAR(9) PRIMARY KEY not null,
    Nombre VARCHAR (50),
    Direccion VARCHAR(50),
    Salario FLOAT,
    Telefono INTEGER,
    fechaContratacion DATE,
    fechaNacimiento DATE,
    Formacion VARCHAR (50), 
    Atraccion INTEGER,
    Edad INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaNacimiento)) VIRTUAL,
    tiempo_trabajado INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaContratacion)) VIRTUAL,
    FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Hosteleros(
    DNI CHAR(9) PRIMARY KEY not null,
    Nombre VARCHAR (50),
    Direccion VARCHAR(50),
    Salario FLOAT,
    Telefono INTEGER,
    fechaContratacion DATE,
    fechaNacimiento DATE,
    Formacion VARCHAR (50), 
    Establecimiento INTEGER,
    Edad INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaNacimiento)) VIRTUAL,
    tiempo_trabajado INTEGER GENERATED ALWAYS AS (DATEDIFF('now', fechaContratacion)) VIRTUAL,
    FOREIGN KEY(Establecimiento) REFERENCES Hosteleria(codigoRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);

