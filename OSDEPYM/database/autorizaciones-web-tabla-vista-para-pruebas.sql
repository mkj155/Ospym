-- Creación de tablas
CREATE TYPE dbo.NOMBRE FROM varchar(30) NULL;
CREATE TABLE dbo.AFILIADOS(
	ID_AFILIADO int NOT NULL,
	ID_TITULAR int NOT NULL,	
	APELLIDO varchar(100) NULL,
	NOMBRE dbo.NOMBRE NULL
);

CREATE TABLE dbo.AFILIADOSCOBERTURA(
	ID_AFILIADO int NOT NULL,
	ID_TITULAR int NOT NULL,
	FECHAINICIO DATETIME NOT NULL,
	FECHAFIN DATETIME NULL
);

-- Creación de la vista
create view dbo.V_FAMILIARES_A_CARGO as
select a.ID_AFILIADO, a.ID_TITULAR, a.APELLIDO, a.NOMBRE
from AFILIADOSCOBERTURA ac, 
     AFILIADOS a
where FECHAINICIO <= GETDATE()
and ISNULL(FECHAFIN,'20991231') >= GETDATE()
and ac.ID_AFILIADO = a.ID_AFILIADO;

-- Creación de datos
insert into dbo.AFILIADOS values(1,1,'Titular apellido','titular nombre');
insert into dbo.AFILIADOS values(2,1,'Hijo 1 apellido','Hijo 1 nombre');
insert into dbo.AFILIADOS values(3,1,'Hijo 2 apellido','Hijo 2 nombre');

insert into dbo.AFILIADOSCOBERTURA values(1,1,'20190101', '20191231');
insert into dbo.AFILIADOSCOBERTURA values(2,1, '20190101', '20191231');
insert into dbo.AFILIADOSCOBERTURA values(3,1, '20190101', '20191231');