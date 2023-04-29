--Script de creación de una base de datos
--Autores: Miguel Leal, Pablo Lobato, Manuel Estévez, Pablo Seijo
--Fecha: 12/abr/2023

--Creación de la base de datos
CREATE DATABASE ParqueAtraccionesGallaecia;

--Conexión a la base de datos

--Creación de la tabla Usuarios
CREATE TABLE Usuarios (
    ID SERIAL PRIMARY KEY,
    Nombre VARCHAR(50) PRIMARY KEY,
    Email VARCHAR(50),
    Clave VARCHAR(50),
    TipoUsuario VARCHAR(50)
);

--Creación de la tabla Visitantes
CREATE TABLE Visitantes (
    DNI CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    fechaNacimiento DATE,
    nombreUsuario VARCHAR(50),
    FOREIGN KEY (nombreUsuario) REFERENCES Usuarios (Nombre) ON DELETE CASCADE ON UPDATE CASCADE
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
    CosteMantenimiento FLOAT,
    EnReparacion BOOLEAN,
    Ubicaciones VARCHAR(50),
    Descripcion VARCHAR(200)
);

--Creación de la tabla Espectaculos
CREATE TABLE Espectaculos (
    ID SERIAL PRIMARY KEY,
    Nombre VARCHAR(50),
    Sesion VARCHAR(50),
    HoraInicio TIME,
    HoraFin TIME,
    Tematica VARCHAR(50),
    Descripcion VARCHAR(100),
    Ubicacion VARCHAR(50)
);

--Creación de la tabla Comer
CREATE TABLE Comer (
    FechaVisita DATE,
    horaVisita TIME,
    Visitante CHAR(9),
    Establecimiento INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Establecimiento) REFERENCES Hosteleria (codigoRegistro) ON DELETE CASCADE ON UPDATE CASCADE
);

--Creación de la tabla Ir
CREATE TABLE Ir (
    FechaVisita DATE,
    horaVisita TIME,
    Visitante CHAR(9),
    Atraccion INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Atraccion) REFERENCES Atracciones (NumeroRegistro) ON DELETE CASCADE ON UPDATE CASCADE
);


--Creación de la tabla Asistir
CREATE TABLE Asistir (
    FechaVisita DATE,
    horaVisita TIME,
    Visitante CHAR(9),
    Espectaculo INTEGER,
    FOREIGN KEY (Visitante) REFERENCES Visitantes (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Espectaculo) REFERENCES Espectaculos (ID) ON DELETE CASCADE ON UPDATE CASCADE
);
--Creación de una función que devuelve los años transcurridos desde una fecha, para poder hacer los atributos calculados de edad y tiempoTrabajando de los empleados
CREATE OR REPLACE FUNCTION get_time( inicio DATE )
RETURNS INTEGER
AS $CODE$
BEGIN
    RETURN EXTRACT(year from AGE(inicio));
END
$CODE$
LANGUAGE plpgsql IMMUTABLE;


--Creación de la tabla TrabajadoresEspectaculo
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
    Edad INTEGER GENERATED ALWAYS AS (get_time(fechaNacimiento)) STORED,
    tiempoTrabajando INTEGER GENERATED ALWAYS AS (get_time(fechaContratacion)) STORED,
    FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE
);

--Creación de la tabla TrabajadoresAdministracion
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
    Edad INTEGER GENERATED ALWAYS AS (get_time(fechaNacimiento)) STORED,
    tiempoTrabajando INTEGER GENERATED ALWAYS AS (get_time(fechaContratacion)) STORED,
    FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);

--Creación de la tabla TrabajadoresMantenimiento
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
    Edad INTEGER GENERATED ALWAYS AS (get_time(fechaNacimiento)) STORED,
    tiempoTrabajando INTEGER GENERATED ALWAYS AS (get_time(fechaContratacion)) STORED,
    FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);

--Creación de la tabla Hosteleros
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
    Edad INTEGER GENERATED ALWAYS AS (get_time(fechaNacimiento)) STORED,
    tiempoTrabajando INTEGER GENERATED ALWAYS AS (get_time(fechaContratacion)) STORED,
    FOREIGN KEY(Establecimiento) REFERENCES Hosteleria(codigoRegistro) ON DELETE SET NULL ON UPDATE CASCADE
);
