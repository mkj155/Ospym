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
