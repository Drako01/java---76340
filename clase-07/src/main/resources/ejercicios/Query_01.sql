CREATE DATABASE IF NOT EXISTS coder;
USE coder;

CREATE TABLE alumno(
	nombre VARCHAR(20),
    apellido VARCHAR(20)
);

SELECT * FROM alumno;

INSERT INTO alumno VALUES
	("Alejandro" , "Di Stefano"),
    ("Alejandro" , "Perez"),
    ("Lionel" , "Messi"),
    ("Gabriel" , "Bertella");
    
ALTER TABLE alumno ADD COLUMN id INT AUTO_INCREMENT NOT NULL PRIMARY KEY;
ALTER TABLE alumno ADD COLUMN dni INT NULL;

INSERT INTO alumno VALUES
	("Susana" , "Gimenez", 0, 22233355);
    
-- ALTER TABLE alumno 
-- MODIFY COLUMN id INT PRIMARY KEY FIRST;
-- ALTER TABLE alumno DROP PRIMARY KEY; -- Solo si es necesario y no hay claves foráneas
-- ALTER TABLE alumno MODIFY COLUMN id INT NOT NULL FIRST;
ALTER TABLE alumno ADD PRIMARY KEY (id); -- Si era clave primaria antes

ALTER TABLE alumno MODIFY COLUMN id INT  AUTO_INCREMENT NOT NULL PRIMARY KEY FIRST;
INSERT INTO alumno VALUES
	(0, "Diego" , "Perez", 11555666);

UPDATE alumno SET dni = 333666999 WHERE id = 1;
UPDATE alumno SET dni = 55222666 WHERE id = 2;
UPDATE alumno SET dni = 99555775 WHERE id = 3;
UPDATE alumno SET dni = 234556897 WHERE id = 4;

DESC alumno;

DELETE FROM alumno WHERE id = 6;

DROP TABLE alumno;