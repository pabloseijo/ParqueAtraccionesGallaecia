'''
@author Miguel Leal, Pablo Lobato, Manuel Estévez, Pablo Seijo
@date 12/abr/2023
@description script de creacion de una base de datos
'''

# Importamos la libreria para la gestion de la base de datos
import sqlite3


# Nos conectamos a la base de datos del Parque de Atracciones
miConexion = sqlite3.connect("ParqueAtraccionesGallaecia")

# Con la conexión, crea un objeto cursor
miCursor = miConexion.cursor()

# Creo las tablas (cabe destacar que autoincrement en postgres seria SERIAL
miCursor.execute('''
        CREATE TABLE Espectaculos(
        ID INTEGER PRIMARY KEY AUTOINCREMENT, 
        Nombre VARCHAR(50),
        Sesion VARCHAR(50),
        HorarioInicio TIME,
        HorarioFin TIME,
        Tematica VARCHAR(50),
        Descripcion Sesion VARCHAR(100),
        Ubicacion VARCHAR(50) )
''')

miCursor.execute('''
        CREATE TABLE Visitantes(
        DNI CHAR(9) PRIMARY KEY not null,
        Nombre VARCHAR (50),
        correoElectronico VARCHAR(50),
        fechaNacimiento DATE)
''')

miCursor.execute('''
        CREATE TABLE Hosteleria(
        codigoRegistro INTEGER PRIMARY KEY AUTOINCREMENT,
        Nombre VARCHAR (50),
        Aforo INTEGER,
        Ubicaciones VARCHAR(50),
        HoraApertura TIME,
        HoraCierre TIME,
        Recaudacion FLOAT)
''')

miCursor.execute('''
        CREATE TABLE Atracciones(
        NumeroRegistro INTEGER PRIMARY KEY AUTOINCREMENT not null,
        Nombre VARCHAR (50),
        Aforo INTEGER,
        AlturaMin INTEGER,
        CosteMantenimiento INTEGER,
        EnReparacion BOOLEAN,
        Ubicaciones VARCHAR(50),
        Descripcion VARCHAR(200) )
''')

miCursor.execute('''
        CREATE TABLE Ir(
        FechaVisita DATE,
        Visitante CHAR(9),
        Atraccion INTEGER,
        FOREIGN KEY(Visitante) REFERENCES Visitantes(DNI) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE CASCADE ON UPDATE CASCADE)
''')


miCursor.execute('''
        CREATE TABLE Comer(
        FechaVisita DATE,
        Visitante CHAR(9),
        Establecimiento INTEGER,
        FOREIGN KEY(Visitante) REFERENCES Visitantes(DNI) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY(Establecimiento) REFERENCES Hosteleria(codigoRegistro) ON DELETE CASCADE ON UPDATE CASCADE)
''')

miCursor.execute('''
        CREATE TABLE Asistir(
        FechaVisita DATE,
        Visitante CHAR(9),
        Espectaculo INTEGER,
        FOREIGN KEY(Visitante) REFERENCES Visitantes(DNI) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE CASCADE ON UPDATE CASCADE)
''')


miCursor.execute('''
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
    Edad INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaNacimiento))/365)),
    tiempo_trabajado INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaContratacion))/365)),
    FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE
);
''')




miCursor.execute('''
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
        Edad INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaNacimiento))/365)),
        tiempo_trabajado INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaContratacion))/365)),
        FOREIGN KEY(Espectaculo) REFERENCES Espectaculos(ID) ON DELETE SET NULL ON UPDATE CASCADE,
        FOREIGN KEY(Atraccion) REFERENCES Atracciones(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE )
''')


miCursor.execute('''
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
        Edad INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaNacimiento))/365)),
        tiempo_trabajado INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaContratacion))/365)),
        FOREIGN KEY(Atraccion) REFERENCES Espectaculos(NumeroRegistro) ON DELETE SET NULL ON UPDATE CASCADE )
''')

miCursor.execute('''
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
        Edad INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaNacimiento))/365)),
        tiempo_trabajado INTEGER GENERATED ALWAYS AS (ROUND((julianday('now') - julianday(fechaContratacion))/365)),
        FOREIGN KEY(Establecimiento) REFERENCES Hosteleria(codigoRegistro) ON DELETE SET NULL ON UPDATE CASCADE )
''')

#Cierro la conexion con la base de datos
miConexion.close()
