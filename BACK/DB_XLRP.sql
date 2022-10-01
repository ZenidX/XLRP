DROP DATABASE IF EXISTS db_xlrp;
CREATE DATABASE IF NOT EXISTS db_xlrp;
USE db_xlrp;

DROP TABLE IF EXISTS perfiles;
CREATE TABLE IF NOT EXISTS perfiles(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email 		VARCHAR(100),
    contraseña  VARCHAR(255),
    nombre 		VARCHAR(255),
    apellidos 	VARCHAR(255),
    edad		INT,
    titular		VARCHAR(255),
    municipio	VARCHAR(255),
    cp 			VARCHAR(10),
    telefono 	VARCHAR(16),
    foto 		BLOB,
    terminos	VARCHAR(255)
);
INSERT INTO perfiles (id, nombre, apellidos, email, contraseña, edad, titular, municipio, cp, telefono, foto) VALUES
  (1,"Xavi", "Lara Moreno","zenid77@gmail.com","1234",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","URL_foto_xavi"),
  (2,"Ruben","Medina Martinez","ruskimartinez@gmail.com","1234",25,"Animador Gráfico 3D","Hospitalet de Llobregat","08905","689992760","URL_foto_ruben"),
  (3,"Pol","Vela","polvelaprous@gmail.com","1234",24,"Policia","Sant Cugat del Vallés", "08195","656393148","URL_foto_pol"),
  (4,"Alejandra","pa pa papure","samaPantufla@papurree.ea","1234",21,"Programadora","Barcelona","78012","987654321","foto"),
  (5,"Luis","Martínez","luismartinez.rodriguez.1@gmail.com","1234","25","Químico","Badalona","08917","606297136","URL_foto_luis");
SELECT * FROM perfiles;
DROP TABLE IF EXISTS servicios;
CREATE TABLE IF NOT EXISTS servicios(
	id_servicio    	INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_profesional 	INT NOT NULL,
    foto 			BLOB,
    titular 		VARCHAR(100),
    descripcion 	VARCHAR(1000),
    horario		 	VARCHAR(255),
    tarifa 			VARCHAR(255),
	FOREIGN KEY (id_profesional) REFERENCES db_xlrp.perfiles(id)
);
INSERT INTO servicios (id_servicio, id_profesional, foto, titular, descripcion,horario, tarifa) VALUES
  (1,1,"foto","Clases Particulares de Matemáticas", "Son 5 años de experiencia motivando a chavales a no tenerle miedo a las matemáticas.","Jornada completa","20€/hora"),
  (2,4,"foto","Clases Particulares de Química","Preparación para clases universitarias","Jornada completa","20€/hora"),
  (3,2,"foto","Clases Particulares de Animación 3D","Currículums dinamicos y mucho más","Jornada completa","20€/hora"),
  (4,2,"foto","Edición Photoshop", "Con fotoshop te hago lo que quieras","Jornada completa","100€/hora"),
  (5,1,"foto","Examenes de Matemáticas", "Te ayudo con tus examenes de asignaturas matematicas del grado","Jornada completa","100€/hora sin presiones, 300€/hora preparado"),
  (6,4,"foto","Calidad de las piscinas", "Gestión de calidad del agua","Martes por la mañana","500€/servicio"),
  (7,3,"foto","Guardaespaldas", "Vigilancia 24/7 e investigación","Jornada completa","300€/hora"),
  (8,5,"foto","Web development","Desarrollo de páginas web con cualquier funcionalidad deseada","Fines de semana","1.000€/página");
SELECT * FROM servicios;
DROP TABLE IF EXISTS clientes;
CREATE TABLE IF NOT EXISTS clientes(
	id_cita     INT PRIMARY KEY AUTO_INCREMENT,
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
INSERT INTO clientes (id_cita, id_cliente, id_servicio, hora, direccion, municipio, cp, comentario) VALUES
  (1,1,1,"10:00","Calle Sant Patricio 2","Badalona","08194","Lorem Ipsum"),
  (2,2,2,"13:00","Calle Caps 160","Barcelona","01923","Lorem Ipsum"),
  (3,3,3,"12:30","Carrer Angosta 4","Barcelona","666666","Lorem Ipsum");
SELECT * FROM clientes;
/*
DROP TABLE IF EXISTS cursos;
CREATE TABLE IF NOT EXISTS cursos(
	id_curso    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_profesor INT NOT NULL,
    titulo 		VARCHAR(255),
	FOREIGN KEY (id_profesor) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS alumnos;
CREATE TABLE IF NOT EXISTS alumnos(
	id_matricula INT PRIMARY KEY AUTO_INCREMENT,
	id_alumno    INT NOT NULL,
    id_curso     INT NOT NULL,
    FOREIGN KEY (id_curso ) REFERENCES db_xlrp.cursos(id_curso),
    FOREIGN KEY (id_alumno) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS actividades;
CREATE TABLE IF NOT EXISTS actividades(
	id_actividad INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_gestor    INT NOT NULL,
	FOREIGN KEY (id_gestor) REFERENCES db_xlrp.perfiles(id)
);
DROP TABLE IF EXISTS participantes;
CREATE TABLE IF NOT EXISTS participantes(
	id_participacion	INT PRIMARY KEY AUTO_INCREMENT,
	id_participante 	INT NOT NULL,
    id_actividad		INT NOT NULL,
    nombre				VARCHAR(255),
    apellidos			VARCHAR(255),
    FOREIGN KEY (id_actividad)    REFERENCES db_xlrp.actividades(id_actividad),
    FOREIGN KEY (id_participante) REFERENCES db_xlrp.perfiles(id)
);