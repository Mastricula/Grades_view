DROP DATABASE IF EXISTS Grades_view;
CREATE DATABASE Grades_view;

use Grades_view;

CREATE TABLE Usuarios (
id_usu INT PRIMARY KEY AUTO_INCREMENT,
usu VARCHAR(15),
passw VARCHAR(25) NOT NULL,
rol VARCHAR(25) NOT NULL
);

CREATE TABLE cursos (
id_curso INT PRIMARY KEY AUTO_INCREMENT,
curso VARCHAR(20) NOT NULL
);

CREATE TABLE materias (
id_materia INT PRIMARY KEY KEY AUTO_INCREMENT,
materia VARCHAR(20) NOT NULL
);

CREATE TABLE Profesores (
id_profe INT PRIMARY KEY AUTO_INCREMENT,
matricula_profe VARCHAR(25) NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido VARCHAR(20) NOT NULL,
cedula VARCHAR(11) NOT NULL,
id_usu INT NOT NULL,
CONSTRAINT fk_profe_usu FOREIGN KEY (id_usu) REFERENCES usuarios(id_usu)
);

CREATE TABLE Estudiantes (
id_estu INT PRIMARY KEY AUTO_INCREMENT,
matricula_estu VARCHAR(25) NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido VARCHAR(20) NOT NULL,
fecha_nacimiento DATE NOT NULL,
id_curso INT NOT NULL,
id_usu INT NOT NULL,
CONSTRAINT fk_Estu_curso FOREIGN KEY (id_curso) REFERENCES cursos(id_curso),
CONSTRAINT fk_estu_usu FOREIGN KEY (id_usu) REFERENCES usuarios(id_usu)
);

CREATE TABLE curso_mate (
id_curso INT,
id_materia INT,
PRIMARY KEY (id_curso, id_materia),
CONSTRAINT fk_inter_estu FOREIGN KEY (id_curso) REFERENCES cursos(id_curso),
CONSTRAINT fk_inter_mate_e FOREIGN KEY (id_materia) REFERENCES materias(id_materia)
);

CREATE TABLE profe_mate (
id_profe INT,
id_materia INT,
PRIMARY KEY (id_profe, id_materia),
CONSTRAINT fk_inter_profe_m FOREIGN KEY (id_profe) REFERENCES profesores(id_profe),
CONSTRAINT fk_inter_mate_p FOREIGN KEY (id_materia) REFERENCES materias(id_materia)
);

CREATE TABLE profe_cursos (
id_profe INT,
id_curso INT,
PRIMARY KEY (id_profe, id_curso),
CONSTRAINT fk_inter_profe_c FOREIGN KEY (id_profe) REFERENCES profesores(id_profe),
CONSTRAINT fk_inter_curso FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

SHOW TABLES;

INSERT INTO Usuarios (usu, passw, rol) VALUES ('Admin', 'admin', 'admin');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('Paulo', '1234', 'profe');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('Aaron', '12345', 'estu');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('Jose', '1234', 'admin');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('P-0000', 'P-0000', 'profe');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('P-0001', 'P-0001', 'profe');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('P-0002', 'P-0002', 'profe');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('P-0000', '2024-0000', 'profe');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('2024-0000', '2024-0000', 'estu');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('2024-0001', '2024-0001', 'estu');
INSERT INTO Usuarios (usu, passw, rol) VALUES ('2024-0002', '2024-0002', 'estu');

SELECT * FROM Usuarios;

INSERT INTO Cursos (curso) VALUES ('1ro de Secundaria');
INSERT INTO Cursos (curso) VALUES ('2do de Secundaria');
INSERT INTO Cursos (curso) VALUES ('3ro de Secundaria');
INSERT INTO Cursos (curso) VALUES ('4to de Secundaria');
INSERT INTO Cursos (curso) VALUES ('5to de Secundaria');
INSERT INTO Cursos (curso) VALUES ('6to de Secundaria');

SELECT * FROM Cursos ;

INSERT INTO Materias (materia) VALUES ('Matematica');
INSERT INTO Materias (materia) VALUES ('Lengua Española');
INSERT INTO Materias (materia) VALUES ('Naturales');
INSERT INTO Materias (materia) VALUES ('Sociales');

SELECT * FROM Materias;

INSERT INTO Estudiantes (matricula_estu, nombre, apellido, fecha_nacimiento, id_curso, id_usu) VALUES ('2024-0000', 'Miguel', 'Alcantara', '2007-01-12', 6, 9);
INSERT INTO Estudiantes (matricula_estu, nombre, apellido, fecha_nacimiento, id_curso, id_usu) VALUES ('2024-0001', 'Dorian', 'Ogando', '2008-12-21', 5, 9);
INSERT INTO Estudiantes (matricula_estu, nombre, apellido, fecha_nacimiento, id_curso, id_usu) VALUES ('2024-0002', 'Joao', 'Navarro', '2009-10-10', 4, 10);

SELECT * FROM Estudiantes;

INSERT INTO Profesores (matricula_profe, nombre, apellido, cedula, id_usu) VALUES ('P-0000','Freidy', 'Nuñes', '00112345671' , 5);
INSERT INTO Profesores (matricula_profe, nombre, apellido, cedula, id_usu) VALUES ('P-0001', 'Maribel', 'Rodriguez', '04598765431', 6);
INSERT INTO Profesores (matricula_profe, nombre, apellido, cedula, id_usu) VALUES ('P-0002', 'Mariela', 'Perdomo', '10145678901', 7);
INSERT INTO Profesores (matricula_profe, nombre, apellido, cedula, id_usu) VALUES ('P-0001', 'Juan', 'Perez', '05732165491', 8);


INSERT INTO profe_mate VALUES (1,1);
INSERT INTO profe_mate VALUES (2,2);
INSERT INTO profe_mate VALUES (3,3);
INSERT INTO profe_mate VALUES (4,4);

SELECT * FROM profe_mate;

INSERT INTO profe_cursos VALUES (1,6);
INSERT INTO profe_cursos VALUES (2,6);
INSERT INTO profe_cursos VALUES (3,6);
INSERT INTO profe_cursos VALUES (4,6);

INSERT INTO profe_cursos VALUES (1,5);
INSERT INTO profe_cursos VALUES (2,5);

INSERT INTO profe_cursos VALUES (3,3);
INSERT INTO profe_cursos VALUES (4,3);

SELECT * FROM profe_cursos;

INSERT INTO curso_mate VALUES (1,1);
INSERT INTO curso_mate VALUES (1,2);
INSERT INTO curso_mate VALUES (1,3);
INSERT INTO curso_mate VALUES (1,4);

INSERT INTO curso_mate VALUES (2,1);
INSERT INTO curso_mate VALUES (2,2);
INSERT INTO curso_mate VALUES (2,3);
INSERT INTO curso_mate VALUES (2,4);

INSERT INTO curso_mate VALUES (3,1);
INSERT INTO curso_mate VALUES (3,2);
INSERT INTO curso_mate VALUES (3,3);
INSERT INTO curso_mate VALUES (3,4);

INSERT INTO curso_mate VALUES (4,1);
INSERT INTO curso_mate VALUES (4,2);
INSERT INTO curso_mate VALUES (4,3);
INSERT INTO curso_mate VALUES (4,4);

INSERT INTO curso_mate VALUES (5,1);
INSERT INTO curso_mate VALUES (5,2);
INSERT INTO curso_mate VALUES (5,3);
INSERT INTO curso_mate VALUES (5,4);

INSERT INTO curso_mate VALUES (6,1);
INSERT INTO curso_mate VALUES (6,2);
INSERT INTO curso_mate VALUES (6,3);
INSERT INTO curso_mate VALUES (6,4);

desc profe_cursos;
desc curso_mate;
desc profe_mate;

SELECT * FROM Profesores;
SELECT * FROM curso_mate;
SELECT * FROM Materias;