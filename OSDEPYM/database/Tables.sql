CREATE TABLE tramites_online.MOTIVOS (
    ID_MOTIVO			int				NOT NULL	IDENTITY	PRIMARY KEY,
	ETIQUETA			varchar(100)	NOT NULL,
);

CREATE TABLE tramites_online.CATEGORIAS (
    ID_CATEGORIA		int				NOT NULL	IDENTITY	PRIMARY KEY,
    ETIQUETA			varchar(100)	NOT NULL
);

CREATE TABLE tramites_online.MOTIVOS_CATEGORIAS (
	ID_MOT_CAT			int				NOT NULL	IDENTITY	PRIMARY KEY,
    ID_MOTIVO			int				NOT NULL	FOREIGN KEY REFERENCES tramites_online.MOTIVOS(ID_MOTIVO),
    ID_CATEGORIA		int				NULL		FOREIGN KEY REFERENCES tramites_online.CATEGORIAS(ID_CATEGORIA),
	CORREO				varchar(100)	NOT NULL
);

CREATE TABLE tramites_online.CONTACTOS (
    ID_CONTACTO			int				NOT NULL	IDENTITY	PRIMARY KEY,
	ID_TRAMITE			varchar(14)		NOT NULL,
	ID_AFILIADO			varchar(30)		NOT NULL,
	ID_MOTIVO			int				NOT NULL,
	ID_CATEGORIA		int,
	NOMBRE_COMPLETO     varchar(100)	NOT NULL,
	COMENTARIO			varchar(1100)	NOT NULL,
	FECHA_CREACION		date            NOT NULL,
	CORREO				varchar(255)	NOT NULL,
);

CREATE TABLE tramites_online.CONTACTO_SEQ(
    ID INT  
);





---------EJECUTAR SEPARADO-----------

CREATE PROCEDURE tramites_online.GET_NEXT_SEQUENCE_VALUE
AS  
    BEGIN 
		DECLARE @value INT	
		BEGIN TRANSACTION
			SELECT @value = ID FROM CONTACTO_SEQ
			IF @value + 1 > 999999
				SET @value = 1;
			ELSE
				SET @value = @value + 1
			UPDATE CONTACTO_SEQ
			SET ID = @value   
		COMMIT TRANSACTION  
		SELECT @value AS ID  
	END; 

