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
    fechaNacimiento varchar(11),
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

CREATE TABLE PROFESOR (
	codigo INT NOT NULL,
    codigo_prof INT NOT NULL,
    estado varchar(25) NOT NULL,
    
    FOREIGN KEY (codigo)
		REFERENCES MIEMBRO(codigo)
);

CREATE TABLE EXTERNO (
	codigo INT NOT NULL,
    dedicacion varchar(15) NOT NULL,
    
    FOREIGN KEY (codigo)
		REFERENCES MIEMBRO(codigo)
);

delete from alumno where codigo = 3;

select m.*, 
	case when a.codigo_alumno is not NULL then 'alumno'
		when p.codigo_prof is not NULL then 'profe'
		when e.dedicacion is not NULL then 'externo'
	end as type,
    a.codigo_alumno,
    a.craest,
    p.codigo_prof,
    p.estado,
    e.dedicacion
from
	miembro m 
	left join
		alumno a on (m.codigo = a.codigo)
	left join
		profesor p on (m.codigo = p.codigo)
	left join
		externo e on (m.codigo = e.codigo)