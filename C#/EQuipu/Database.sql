CREATE TABLE USERS (
	id INT NOT NULL AUTO_INCREMENT,
	username varchar(15),
    password varchar(15),
    PRIMARY KEY(id)
);

INSERT INTO USERS (username, password) VALUES ('degva', '123');

CREATE TABLE MIEMBRO (
	codigo INT NOT NULL,
    nombre varchar(15),
    fechaNacimiento timestamp,
    direccion varchar(15),
    email varchar(15),
    sexo char,
    PRIMARY KEY (codigo)
);

CREATE TABLE ALUMNO (
	codigo INT NOT NULL,
    codigo_alumno INT NOT NULL,
    craest FLOAT NOT NULL,
    
    FOREIGN KEY (codigo)
		REFERENCES MIEMBRO(codigo)
);