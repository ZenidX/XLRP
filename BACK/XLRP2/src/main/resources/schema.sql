DROP TABLE IF EXISTS perfiles;
CREATE TABLE perfiles(
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
