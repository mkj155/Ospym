select * from profesores;
insert into profesores values ('Leonardo','Otero','Cuchimilla 621','Longchamps');
insert into profesores values ('Maximiliano','Zapata','Rivera 588','CABA');
insert into profesores values ('Sabrina','Rojas','Altamira 222','CABA');
insert into profesores values ('Agustin','Sanchez','Malvinas 728','Ciudad Jardin');
insert into profesores values ('Matias','Lavarelo','Negro 411','Torcuato');

select * from cursos;
insert into cursos values ('Matematica');
insert into cursos values ('Fisica');
insert into cursos values ('Quimica');
insert into cursos values ('Lengua');
insert into cursos values ('Literatura');
insert into cursos values ('Psicologia');
insert into cursos values ('Geografia');
insert into cursos values ('Historia');
insert into cursos values ('Contabilidad');

select * from profesorescursos;
insert into profesorescursos values (1,1);
insert into profesorescursos values (1,2);
insert into profesorescursos values (1,3);
insert into profesorescursos values (2,6);
insert into profesorescursos values (2,8);
insert into profesorescursos values (3,9);
insert into profesorescursos values (4,7);
insert into profesorescursos values (5,4);
insert into profesorescursos values (5,5);

SELECT * FROM HIJOS;
INSERT INTO HIJOS VALUES (1,'GOKU','CHAVEZ');
INSERT INTO HIJOS VALUES (1,'PIKACHU','CHAVEZ');
INSERT INTO HIJOS VALUES (2,'DINOSAURIO','LAVARELLO');
INSERT INTO HIJOS VALUES (3,'VIRGOCHO','SANCHEZ');
INSERT INTO HIJOS VALUES (1,'PERELLI','CHAVEZ');
INSERT INTO HIJOS VALUES (3,'DOMADOR','SANCHEZ');
INSERT INTO HIJOS VALUES (4,'TANIA','OTERO');

SELECT * FROM TESTPERSONA;
INSERT INTO TESTPERSONA VALUES ('DAMIAN','CHAVEZ','RIVADAVIA 222','CABA','01-01-1986',5000,0);
INSERT INTO TESTPERSONA VALUES ('MATIAS','LAVARELLO','SABRINA 444','CABA','02-02-1996',5001,1);
INSERT INTO TESTPERSONA VALUES ('AGUSTIN','SANCHEZ','TIGRE 666','CABA','03-03-1990',5002,1);
INSERT INTO TESTPERSONA VALUES ('LEONARDO','OTERO','LONGCHAMP 615','CABA','04-04-1976',5003,0);
