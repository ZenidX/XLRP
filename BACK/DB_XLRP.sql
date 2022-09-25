DROP DATABASE IF EXISTS db_xlrp;
CREATE DATABASE IF NOT EXISTS db_xlrp;
USE db_xlrp;

DROP TABLE IF EXISTS perfiles;
CREATE TABLE IF NOT EXISTS perfiles(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    contraseña  VARCHAR(255),
    nombre 		VARCHAR(255),
    apellidos 	VARCHAR(255),
    edad		INT,
    titulo		VARCHAR(255),
    municipio	VARCHAR(255),
    cp 			VARCHAR(10),
    telefono 	VARCHAR(16),
    email 		VARCHAR(100),
    foto 		VARCHAR(255),
    terminos	VARCHAR(255)
);
INSERT INTO perfiles (id, nombre, apellidos, email, contraseña, edad, titulo, municipio, cp, telefono, foto) VALUES
  (1,"Xavi", "Lara Moreno","zenid77@gmail.com","DoomEternal",24,"Matemático",      "Sant Cugat del Vallés", "08195","656393148","URL_foto_xavi"),
  (2,"Ruben","Medina Martinez","ruskimartinez@gmail.com","1234",25,"Animador Gráfico 3D","Hospitalet de Llobregat","08905","689992760","URL_foto_ruben"),
  (3,"Luis","Martinez","zenid77@gmail.com","DoomEternal",24,"Matemático","Badalona", "08195","656393148","URL_foto_luis"),
  (4,"Pol","Vela","zenid77@gmail.com","DoomEternal",24,"Policia","Sant Cugat del Vallés", "08195","656393148","URL_foto_pol"),
  (5,"Pantufla-Sama","pa pa papure","samaPantufla@papurree.ea","meiamoPantuflaSma",3000,"hda del bozque","my caza del uerto","78012","987654321","fotuu");
SELECT * FROM perfiles;
DROP TABLE IF EXISTS servicios;
CREATE TABLE IF NOT EXISTS servicios(
	id_servicio    	INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_profesional 	INT NOT NULL,
    foto 			VARCHAR(255),
    titulo 			VARCHAR(100),
    descripcion 	VARCHAR(1000),
    horario		 	VARCHAR(255),
    tarifa 			VARCHAR(255),
	FOREIGN KEY (id_profesional) REFERENCES db_xlrp.perfiles(id)
);
INSERT INTO servicios (id_servicio, id_profesional, foto, titulo, descripcion,horario, tarifa) VALUES
  (1,1,"foto","Clases Particulares de Matemáticas", "Son 5 años de experiencia motivando a chavales a no tenerle miedo a las matemáticas.","Hasta el amanecer","20€/hora"),
  (2,3,"foto","Clases Particulares de Química",     "Te enseño a hacer caramelos azules","Hasta el amanecer","20€/hora"),
  (3,2,"foto","Clases Particulares de Animación 3D","Con fotoshop te hago lo que quieras","Hasta el amanecer","20€/hora"),
  (4,2,"foto","Edición Photoshop", "Con fotoshop te hago lo que quieras","Hasta el amanecer","100€/hora+mamada"),
  (5,1,"foto","Examenes de Matemáticas", "Te hago tus examenes de asignaturas matematicas del grado","Hasta el amanecer","100€/hora sin presiones, 300€/hora preparado"),
  (6,3,"foto","Ph piscinas", "Te mido el ph de la piscina","martes por la mañana","tu primogenito"),
  (7,4,"foto","policia gigolo", "Te doy duro con mi porra de cadete de la academia de polica","Hasta el amanecer","300€/hora+mamadas"),
  (8,5,"foticahh","hda zuprema del bozque","manda' a to' mundoo","de pimeh añyo lunah al tece' añyo lunah","5 bolsahh de tigohh");
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
/*
INSERT INTO clientes (id_cita, id_cliente, id_servicio, hora, direccion, municipio, cp, comentario) VALUES
  (1,1,1,"Xavi", "Lara Moreno",24,"Matemático",      "Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_xavi"),
  (2,2,2,"Ruben","",           25,"Animador Gráfico","Cornella",              "08195","656393148","zenid77@gmail.com","URL_foto_ruben"),
  (3,3,3,"Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_luis"),
  (4,4,4,"Xavi","Lara Moreno",24,"Matemático","Sant Cugat del Vallés", "08195","656393148","zenid77@gmail.com","URL_foto_pol");
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

