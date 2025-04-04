CREATE DATABASE IF NOT EXISTS coder_relaciones_2; 
USE coder_relaciones_2;

CREATE TABLE estudiantes (
	id_estudiante INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50)
);

CREATE TABLE cursos (
	id_curso INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre_curso VARCHAR(50),
    id_estudiante INT,
    FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante)
);

INSERT INTO estudiantes (nombre, apellido) VALUES
	("Alejandro", "Di Stefano"),
    ("Ramiro", "Gomez"),
    ("Javier", "Araujo"),
    ("juan", "Trillini");
    
SELECT * FROM estudiantes;

INSERT INTO cursos (nombre_curso, id_estudiante) VALUES
	("Java", 1),
    ("SQL", 2),
    ("Angular", 4),
    ("Curso S/A", null);
    
SELECT * FROM cursos;

TRUNCATE cursos; -- Limpia la Tabla sin eliminarla

/*
	JOINS
*/

-- INNER JOIN
SELECT estudiantes.nombre , cursos.nombre_curso
FROM estudiantes 
INNER JOIN cursos ON estudiantes.id_estudiante = cursos.id_estudiante;

-- LEFT JOIN
SELECT estudiantes.nombre , cursos.nombre_curso
FROM estudiantes 
LEFT JOIN cursos ON estudiantes.id_estudiante = cursos.id_estudiante;

-- RIGHT JOIN
SELECT estudiantes.nombre , cursos.nombre_curso
FROM estudiantes 
RIGHT JOIN cursos ON estudiantes.id_estudiante = cursos.id_estudiante;

-- FULL JOIN - UNION
SELECT estudiantes.nombre , cursos.nombre_curso
FROM estudiantes 
LEFT JOIN cursos ON estudiantes.id_estudiante = cursos.id_estudiante

	UNION

SELECT estudiantes.nombre , cursos.nombre_curso
FROM estudiantes 
RIGHT JOIN cursos ON estudiantes.id_estudiante = cursos.id_estudiante;

-- -------------------------------------------------------------------

CREATE TABLE legajo (
	id_legajo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_estudiante INT UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id_estudiante) 
);

INSERT INTO legajo (id_legajo, id_estudiante) VALUES
	(10001, 1),
    (10002, 2),
    (10003, 3),
    (10004, 4);
    
SELECT * FROM legajo;

SELECT
	e.id_estudiante,
    e.nombre,
    e.apellido,
    c.nombre_curso,
    l.id_legajo
FROM estudiantes e
INNER JOIN cursos c ON e.id_estudiante = c.id_estudiante
INNER JOIN legajo l ON e.id_estudiante = l.id_estudiante;

