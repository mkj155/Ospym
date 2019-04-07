-- ANTES DE REALIZAR CUALQUIER INSERT POR FAVOR DROPEAR LAS TABLAS Y VOLVERLAS A CREAR

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

/* 	INSERT INTO CURSOS (CURSO) VALUES ('Matematica');
	INSERT INTO CURSOS (CURSO) VALUES ('Lengua');
	INSERT INTO CURSOS (CURSO) VALUES ('Sociales');
	INSERT INTO CURSOS (CURSO) VALUES ('Computacion');
	INSERT INTO CURSOS (CURSO) VALUES ('Naturales');	*/

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

-- ANTES DE REALIZAR LOS INSERT POR FAVOR DROPEAR LAS 2 TABLAS Y VOLVERLAS A CREAR
  
INSERT INTO TESTPERSONA (NOMBRE,APELLIDO,DIRECCION,CIUDAD,FECHANACIMIENTO,NROCLIENTE,vegetariano,curso,sexo)  
VALUES ('Matias','Lavarello','Calle 123','Moron','20180620 10:34:09 AM',11111,1,'Matematica','M');
INSERT INTO TESTPERSONA (NOMBRE,APELLIDO,DIRECCION,CIUDAD,FECHANACIMIENTO,NROCLIENTE,vegetariano,curso,sexo)  
VALUES ('Agustin','Sanchez','Calle 456','Barrio Jardin','20180620 10:34:09 AM',22222,0,'Lengua','M');
INSERT INTO TESTPERSONA (NOMBRE,APELLIDO,DIRECCION,CIUDAD,FECHANACIMIENTO,NROCLIENTE,vegetariano,curso,sexo)  
VALUES ('Damian','Chavez','Calle 789','San isidro','20180620 10:34:09 AM',33333,1,'Sociales','M');

INSERT INTO HIJOS (IDPERSONA,NOMBRE,APELLIDO)
VALUES (1,'Jose','Macron');
INSERT INTO HIJOS (IDPERSONA,NOMBRE,APELLIDO)
VALUES (2,'Marco','Polo');
INSERT INTO HIJOS (IDPERSONA,NOMBRE,APELLIDO)
VALUES (3,'Pepito','Fulano');
INSERT INTO HIJOS (IDPERSONA,NOMBRE,APELLIDO)
VALUES (1,'Martin','Campos');
INSERT INTO HIJOS (IDPERSONA,NOMBRE,APELLIDO)
VALUES (2,'Sebastian','Avellaneda');


INSERT INTO MOTIVOS_CONTACTO VALUES ('Agradecimientos');
INSERT INTO MOTIVOS_CONTACTO VALUES ('Reclamos');
INSERT INTO MOTIVOS_CONTACTO VALUES ('Preguntas');
INSERT INTO MOTIVOS_CONTACTO VALUES ('Pedidos');

INSERT INTO CATEG_CONTACTO VALUES ('Prestadores');
INSERT INTO CATEG_CONTACTO VALUES ('Personal Oficina');
INSERT INTO CATEG_CONTACTO VALUES ('Medicos');

INSERT INTO MOTIVO_CATEGORIA VALUES (1,1,'MAIL_1-1@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (1,2,'MAIL_1-2@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (1,3,'MAIL_1-3@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (2,1,'MAIL_2-1@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (2,2,'MAIL_2-2@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (2,3,'MAIL_2-3@MAIL.COM');
INSERT INTO MOTIVO_CATEGORIA VALUES (4,1,'MAIL_4-1@MAIL.COM');
