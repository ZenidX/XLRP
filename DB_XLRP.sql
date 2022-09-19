DROP DATABASE IF EXISTS db_xlrp;
CREATE DATABASE IF NOT EXISTS db_xlrp;
USE db_xlrp;

DROP TABLE IF EXISTS perfiles;
CREATE TABLE IF NOT EXISTS perfiles(
	id INT PRIMARY KEY NOT NULL,
    cuenta		VARCHAR(255),
    contraseña  VARCHAR(255),
    nombre 		VARCHAR(255),
    apellidos 	VARCHAR(255),
    edad		INT,
    titulo		VARCHAR(255),
    municipio	VARCHAR(255),
    cp 			VARCHAR(10),
    telefono 	VARCHAR(16),
    email 		VARCHAR(100),
    foto 		VARCHAR(255)
);
INSERT INTO perfiles (id, cuenta, contraseña, nombre, apellidos, edad, titulo, municipio, cp, telefono, email, foto) VALUES
  (1,"ZenidX",         "DoomEternal","Xavi", "Lara Moreno",24,"Matemático",      "Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_xavi"),
  (2,"ChocloMaravilla","DoomEternal","Ruben","",           25,"Animador Gráfico","Cornella",              "08195","656393148","zenid77@gmail.com","URL_foto_ruben"),
  (3,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_luis"),
  (4,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_pol");
DROP TABLE IF EXISTS servicios;
CREATE TABLE IF NOT EXISTS servicios(
	id_servicio    	INT PRIMARY KEY NOT NULL,
    id_profesional 	INT NOT NULL,
    foto 			VARCHAR(255),
    titulo 			VARCHAR(100),
    descripcion 	VARCHAR(1000),
    horario		 	VARCHAR(255),
    tarifa 			VARCHAR(255),
	FOREIGN KEY (id_profesional) REFERENCES db_xlrp.perfiles(id)
);
/*INSERT INTO servicios (id_servicio, id_profesional, foto, titulo, descripcion,horario, tarifa) VALUES
  (1,"ZenidX",         "DoomEternal","Xavi", "Lara Moreno",24,"Matemático",      "Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_xavi"),
  (2,"ChocloMaravilla","DoomEternal","Ruben","",           25,"Animador Gráfico","Cornella",              "08195","656393148","zenid77@gmail.com","URL_foto_ruben"),
  (3,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_luis"),
  (4,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_pol");
  */
DROP TABLE IF EXISTS clientes;
CREATE TABLE IF NOT EXISTS clientes(
	id_cita     INT PRIMARY KEY,
	id_cliente  INT NOT NULL,
    id_servicio INT NOT NULL,
    hora 		VARCHAR(255),
    direccion	VARCHAR(255),
    municipio	VARCHAR(255),
    cp 			VARCHAR(255),
    comentario	VARCHAR(255),
    FOREIGN KEY (id_servicio) REFERENCES db_xlrp.servicios(id_servicio),
    FOREIGN KEY (id_cliente ) REFERENCES db_xlrp.perfiles(id)
);
/*INSERT INTO perfiles (id, cuenta, contraseña, nombre, apellidos, edad, titulo, municipio, cp, telefono, email, foto) VALUES
  (1,"ZenidX",         "DoomEternal","Xavi", "Lara Moreno",24,"Matemático",      "Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_xavi"),
  (1,"ChocloMaravilla","DoomEternal","Ruben","",           25,"Animador Gráfico","Cornella",              "08195","656393148","zenid77@gmail.com","URL_foto_ruben"),
  (1,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_luis"),
  (1,"ZenidX","DoomEternal","Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_pol");
*/
/*
DROP TABLE IF EXISTS cursos;
CREATE TABLE IF NOT EXISTS cursos(
	id_curso    INT PRIMARY KEY NOT NULL,
    id_profesor INT NOT NULL,
    titulo 		VARCHAR(255),
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
	id_participacion	INT PRIMARY KEY,
	id_participante 	INT NOT NULL,
    id_actividad		INT NOT NULL,
    nombre				VARCHAR(255),
    apellidos			VARCHAR(255),
    FOREIGN KEY (id_actividad)    REFERENCES db_xlrp.actividades(id_actividad),
    FOREIGN KEY (id_participante) REFERENCES db_xlrp.perfiles(id)
);*/

