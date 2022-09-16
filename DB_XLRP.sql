DROP DATABASE IF EXISTS db_xlrp;
CREATE DATABASE IF NOT EXISTS db_xlrp;
USE db_xlrp;

DROP TABLE IF EXISTS perfiles;
CREATE TABLE IF NOT EXISTS perfiles(
	id INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(255)
);
DROP TABLE IF EXISTS servicios;
CREATE TABLE IF NOT EXISTS servicios(
	id_servicio    INT PRIMARY KEY NOT NULL,
    id_profesional INT NOT NULL,
	FOREIGN KEY (id_profesional) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS clientes;
CREATE TABLE IF NOT EXISTS clientes(
	id_cita     INT PRIMARY KEY,
	id_cliente  INT NOT NULL,
    id_servicio INT NOT NULL,
    FOREIGN KEY (id_servicio) REFERENCES db_xlrp.servicios(id_servicio),
    FOREIGN KEY (id_cliente ) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS cursos;
CREATE TABLE IF NOT EXISTS cursos(
	id_curso    INT PRIMARY KEY NOT NULL,
    id_profesor INT NOT NULL,
	FOREIGN KEY (id_profesor) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS alumnos;
CREATE TABLE IF NOT EXISTS alumnos(
	id_matricula INT PRIMARY KEY,
	id_alumno    INT NOT NULL,
    id_curso     INT NOT NULL,
    FOREIGN KEY (id_curso ) REFERENCES db_xlrp.cursos(id_curso),
    FOREIGN KEY (id_alumno) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS actividades;
CREATE TABLE IF NOT EXISTS actividades(
	id_actividad INT PRIMARY KEY NOT NULL,
    id_gestor    INT NOT NULL,
	FOREIGN KEY (id_gestor) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS participantes;
CREATE TABLE IF NOT EXISTS participantes(
	id_participacion INT PRIMARY KEY,
	id_participante  INT NOT NULL,
    id_actividad     INT NOT NULL,
    FOREIGN KEY (id_actividad)    REFERENCES db_xlrp.actividades(id_actividad),
    FOREIGN KEY (id_participante) REFERENCES db_xlrp.perfiles(id)
);

