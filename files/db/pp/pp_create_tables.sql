
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: Usuario                                                                                                //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.Usuario

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.Usuario CASCADE;

CREATE TABLE massoftware.Usuario
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº usuario
	numero INTEGER NOT NULL  CONSTRAINT Usuario_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_Usuario_0 ON massoftware.Usuario (numero);

CREATE UNIQUE INDEX u_Usuario_1 ON massoftware.Usuario (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatUsuario() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatUsuario() RETURNS TRIGGER AS $formatUsuario$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatUsuario$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatUsuario ON massoftware.Usuario CASCADE;

CREATE TRIGGER tgFormatUsuario BEFORE INSERT OR UPDATE
	ON massoftware.Usuario FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatUsuario();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.Usuario;

-- SELECT * FROM massoftware.Usuario LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.Usuario;

-- SELECT * FROM massoftware.Usuario WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: SeguridadModulo                                                                                        //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.SeguridadModulo

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.SeguridadModulo CASCADE;

CREATE TABLE massoftware.SeguridadModulo
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº módulo
	numero INTEGER NOT NULL  CONSTRAINT SeguridadModulo_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_SeguridadModulo_0 ON massoftware.SeguridadModulo (numero);

CREATE UNIQUE INDEX u_SeguridadModulo_1 ON massoftware.SeguridadModulo (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatSeguridadModulo() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatSeguridadModulo() RETURNS TRIGGER AS $formatSeguridadModulo$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatSeguridadModulo$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatSeguridadModulo ON massoftware.SeguridadModulo CASCADE;

CREATE TRIGGER tgFormatSeguridadModulo BEFORE INSERT OR UPDATE
	ON massoftware.SeguridadModulo FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatSeguridadModulo();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.SeguridadModulo;

-- SELECT * FROM massoftware.SeguridadModulo LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.SeguridadModulo;

-- SELECT * FROM massoftware.SeguridadModulo WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: SeguridadPuerta                                                                                        //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.SeguridadPuerta

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.SeguridadPuerta CASCADE;

CREATE TABLE massoftware.SeguridadPuerta
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº módulo
	numero INTEGER NOT NULL  CONSTRAINT SeguridadPuerta_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- I.D
	equate VARCHAR(30) NOT NULL, 
	
	-- Módulo
	seguridadModulo VARCHAR(36)  NOT NULL  REFERENCES massoftware.SeguridadModulo (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_SeguridadPuerta_0 ON massoftware.SeguridadPuerta (seguridadModulo, numero);

CREATE UNIQUE INDEX u_SeguridadPuerta_1 ON massoftware.SeguridadPuerta (seguridadModulo, TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatSeguridadPuerta() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatSeguridadPuerta() RETURNS TRIGGER AS $formatSeguridadPuerta$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.equate := massoftware.white_is_null(NEW.equate);
	 NEW.seguridadModulo := massoftware.white_is_null(NEW.seguridadModulo);

	RETURN NEW;
END;
$formatSeguridadPuerta$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatSeguridadPuerta ON massoftware.SeguridadPuerta CASCADE;

CREATE TRIGGER tgFormatSeguridadPuerta BEFORE INSERT OR UPDATE
	ON massoftware.SeguridadPuerta FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatSeguridadPuerta();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.SeguridadPuerta;

-- SELECT * FROM massoftware.SeguridadPuerta LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.SeguridadPuerta;

-- SELECT * FROM massoftware.SeguridadPuerta WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: TipoSucursal                                                                                           //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.TipoSucursal

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.TipoSucursal CASCADE;

CREATE TABLE massoftware.TipoSucursal
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº tipo
	numero INTEGER NOT NULL  CONSTRAINT TipoSucursal_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_TipoSucursal_0 ON massoftware.TipoSucursal (numero);

CREATE UNIQUE INDEX u_TipoSucursal_1 ON massoftware.TipoSucursal (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatTipoSucursal() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatTipoSucursal() RETURNS TRIGGER AS $formatTipoSucursal$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatTipoSucursal$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatTipoSucursal ON massoftware.TipoSucursal CASCADE;

CREATE TRIGGER tgFormatTipoSucursal BEFORE INSERT OR UPDATE
	ON massoftware.TipoSucursal FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatTipoSucursal();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.TipoSucursal;

-- SELECT * FROM massoftware.TipoSucursal LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.TipoSucursal;

-- SELECT * FROM massoftware.TipoSucursal WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: Sucursal                                                                                               //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.Sucursal

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.Sucursal CASCADE;

CREATE TABLE massoftware.Sucursal
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº sucursal
	numero INTEGER NOT NULL  CONSTRAINT Sucursal_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- Abreviatura
	abreviatura VARCHAR(5) NOT NULL, 
	
	-- Tipo sucursal
	tipoSucursal VARCHAR(36)  NOT NULL  REFERENCES massoftware.TipoSucursal (id), 
	
	-- Cuenta clientes desde
	cuentaClientesDesde VARCHAR(7), 
	
	-- Cuenta clientes hasta
	cuentaClientesHasta VARCHAR(7), 
	
	-- Cantidad caracteres clientes
	cantidadCaracteresClientes INTEGER NOT NULL  CONSTRAINT Sucursal_cantidadCaracteresClientes_chk CHECK ( cantidadCaracteresClientes >= 3 AND cantidadCaracteresClientes <= 6  ), 
	
	-- Identificacion numérica clientes
	identificacionNumericaClientes BOOLEAN NOT NULL, 
	
	-- Permite cambiar clientes
	permiteCambiarClientes BOOLEAN NOT NULL, 
	
	-- Cuenta proveedores desde
	cuentaProveedoresDesde VARCHAR(7), 
	
	-- Cuenta proveedores hasta
	cuentaProveedoresHasta VARCHAR(7), 
	
	-- Cantidad caracteres proveedores
	cantidadCaracteresProveedores INTEGER NOT NULL  CONSTRAINT Sucursal_cantidadCaracteresProveedores_chk CHECK ( cantidadCaracteresProveedores >= 3 AND cantidadCaracteresProveedores <= 6  ), 
	
	-- Identificacion numérica proveedores
	identificacionNumericaProveedores BOOLEAN NOT NULL, 
	
	-- Permite cambiar proveedores
	permiteCambiarProveedores BOOLEAN NOT NULL, 
	
	-- Clientes ocacionales desde
	clientesOcacionalesDesde INTEGER NOT NULL  CONSTRAINT Sucursal_clientesOcacionalesDesde_chk CHECK ( clientesOcacionalesDesde >= 1  ), 
	
	-- Clientes ocacionales hasta
	clientesOcacionalesHasta INTEGER NOT NULL  CONSTRAINT Sucursal_clientesOcacionalesHasta_chk CHECK ( clientesOcacionalesHasta >= 1  ), 
	
	-- Número cobranza desde
	numeroCobranzaDesde INTEGER NOT NULL  CONSTRAINT Sucursal_numeroCobranzaDesde_chk CHECK ( numeroCobranzaDesde >= 1  ), 
	
	-- Número cobranza hasta
	numeroCobranzaHasta INTEGER NOT NULL  CONSTRAINT Sucursal_numeroCobranzaHasta_chk CHECK ( numeroCobranzaHasta >= 1  )
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_Sucursal_0 ON massoftware.Sucursal (numero);

CREATE UNIQUE INDEX u_Sucursal_1 ON massoftware.Sucursal (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

CREATE UNIQUE INDEX u_Sucursal_2 ON massoftware.Sucursal (TRANSLATE(LOWER(TRIM(abreviatura))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatSucursal() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatSucursal() RETURNS TRIGGER AS $formatSucursal$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.abreviatura := massoftware.white_is_null(NEW.abreviatura);
	 NEW.tipoSucursal := massoftware.white_is_null(NEW.tipoSucursal);
	 NEW.cuentaClientesDesde := massoftware.white_is_null(NEW.cuentaClientesDesde);
	 NEW.cuentaClientesHasta := massoftware.white_is_null(NEW.cuentaClientesHasta);
	 NEW.cuentaProveedoresDesde := massoftware.white_is_null(NEW.cuentaProveedoresDesde);
	 NEW.cuentaProveedoresHasta := massoftware.white_is_null(NEW.cuentaProveedoresHasta);

	RETURN NEW;
END;
$formatSucursal$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatSucursal ON massoftware.Sucursal CASCADE;

CREATE TRIGGER tgFormatSucursal BEFORE INSERT OR UPDATE
	ON massoftware.Sucursal FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatSucursal();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.Sucursal;

-- SELECT * FROM massoftware.Sucursal LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.Sucursal;

-- SELECT * FROM massoftware.Sucursal WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: EjercicioContable                                                                                      //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.EjercicioContable

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.EjercicioContable CASCADE;

CREATE TABLE massoftware.EjercicioContable
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº ejercicio
	numero INTEGER NOT NULL  CONSTRAINT EjercicioContable_numero_chk CHECK ( numero >= 1  ), 
	
	-- Apertura
	apertura DATE NOT NULL, 
	
	-- Cierre
	cierre DATE NOT NULL, 
	
	-- Cerrado
	cerrado BOOLEAN NOT NULL, 
	
	-- Módulos cerrados
	cerradoModulos BOOLEAN NOT NULL, 
	
	-- Comentario
	comentario VARCHAR(250)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_EjercicioContable_0 ON massoftware.EjercicioContable (numero);

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatEjercicioContable() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatEjercicioContable() RETURNS TRIGGER AS $formatEjercicioContable$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.comentario := massoftware.white_is_null(NEW.comentario);

	RETURN NEW;
END;
$formatEjercicioContable$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatEjercicioContable ON massoftware.EjercicioContable CASCADE;

CREATE TRIGGER tgFormatEjercicioContable BEFORE INSERT OR UPDATE
	ON massoftware.EjercicioContable FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatEjercicioContable();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.EjercicioContable;

-- SELECT * FROM massoftware.EjercicioContable LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.EjercicioContable;

-- SELECT * FROM massoftware.EjercicioContable WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: CentroCostoContable                                                                                    //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.CentroCostoContable

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.CentroCostoContable CASCADE;

CREATE TABLE massoftware.CentroCostoContable
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº cc
	numero INTEGER NOT NULL  CONSTRAINT CentroCostoContable_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- Abreviatura
	abreviatura VARCHAR(5) NOT NULL, 
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_CentroCostoContable_0 ON massoftware.CentroCostoContable (ejercicioContable, numero);

CREATE UNIQUE INDEX u_CentroCostoContable_1 ON massoftware.CentroCostoContable (ejercicioContable, TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

CREATE UNIQUE INDEX u_CentroCostoContable_2 ON massoftware.CentroCostoContable (ejercicioContable, TRANSLATE(LOWER(TRIM(abreviatura))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatCentroCostoContable() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatCentroCostoContable() RETURNS TRIGGER AS $formatCentroCostoContable$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.abreviatura := massoftware.white_is_null(NEW.abreviatura);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);

	RETURN NEW;
END;
$formatCentroCostoContable$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatCentroCostoContable ON massoftware.CentroCostoContable CASCADE;

CREATE TRIGGER tgFormatCentroCostoContable BEFORE INSERT OR UPDATE
	ON massoftware.CentroCostoContable FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatCentroCostoContable();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.CentroCostoContable;

-- SELECT * FROM massoftware.CentroCostoContable LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.CentroCostoContable;

-- SELECT * FROM massoftware.CentroCostoContable WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: TipoPuntoEquilibrio                                                                                    //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.TipoPuntoEquilibrio

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.TipoPuntoEquilibrio CASCADE;

CREATE TABLE massoftware.TipoPuntoEquilibrio
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº tipo
	numero INTEGER NOT NULL  CONSTRAINT TipoPuntoEquilibrio_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_TipoPuntoEquilibrio_0 ON massoftware.TipoPuntoEquilibrio (numero);

CREATE UNIQUE INDEX u_TipoPuntoEquilibrio_1 ON massoftware.TipoPuntoEquilibrio (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatTipoPuntoEquilibrio() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatTipoPuntoEquilibrio() RETURNS TRIGGER AS $formatTipoPuntoEquilibrio$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatTipoPuntoEquilibrio$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatTipoPuntoEquilibrio ON massoftware.TipoPuntoEquilibrio CASCADE;

CREATE TRIGGER tgFormatTipoPuntoEquilibrio BEFORE INSERT OR UPDATE
	ON massoftware.TipoPuntoEquilibrio FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatTipoPuntoEquilibrio();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.TipoPuntoEquilibrio;

-- SELECT * FROM massoftware.TipoPuntoEquilibrio LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.TipoPuntoEquilibrio;

-- SELECT * FROM massoftware.TipoPuntoEquilibrio WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: PuntoEquilibrio                                                                                        //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.PuntoEquilibrio

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.PuntoEquilibrio CASCADE;

CREATE TABLE massoftware.PuntoEquilibrio
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº cc
	numero INTEGER NOT NULL  CONSTRAINT PuntoEquilibrio_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- Tipo
	tipoPuntoEquilibrio VARCHAR(36)  NOT NULL  REFERENCES massoftware.TipoPuntoEquilibrio (id), 
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_PuntoEquilibrio_0 ON massoftware.PuntoEquilibrio (ejercicioContable, numero);

CREATE UNIQUE INDEX u_PuntoEquilibrio_1 ON massoftware.PuntoEquilibrio (ejercicioContable, TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatPuntoEquilibrio() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatPuntoEquilibrio() RETURNS TRIGGER AS $formatPuntoEquilibrio$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.tipoPuntoEquilibrio := massoftware.white_is_null(NEW.tipoPuntoEquilibrio);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);

	RETURN NEW;
END;
$formatPuntoEquilibrio$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatPuntoEquilibrio ON massoftware.PuntoEquilibrio CASCADE;

CREATE TRIGGER tgFormatPuntoEquilibrio BEFORE INSERT OR UPDATE
	ON massoftware.PuntoEquilibrio FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatPuntoEquilibrio();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.PuntoEquilibrio;

-- SELECT * FROM massoftware.PuntoEquilibrio LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.PuntoEquilibrio;

-- SELECT * FROM massoftware.PuntoEquilibrio WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: CostoVenta                                                                                             //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.CostoVenta

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.CostoVenta CASCADE;

CREATE TABLE massoftware.CostoVenta
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº tipo
	numero INTEGER NOT NULL  CONSTRAINT CostoVenta_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_CostoVenta_0 ON massoftware.CostoVenta (numero);

CREATE UNIQUE INDEX u_CostoVenta_1 ON massoftware.CostoVenta (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatCostoVenta() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatCostoVenta() RETURNS TRIGGER AS $formatCostoVenta$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatCostoVenta$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatCostoVenta ON massoftware.CostoVenta CASCADE;

CREATE TRIGGER tgFormatCostoVenta BEFORE INSERT OR UPDATE
	ON massoftware.CostoVenta FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatCostoVenta();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.CostoVenta;

-- SELECT * FROM massoftware.CostoVenta LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.CostoVenta;

-- SELECT * FROM massoftware.CostoVenta WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: CuentaContable                                                                                         //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.CuentaContable

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.CuentaContable CASCADE;

CREATE TABLE massoftware.CuentaContable
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Cuenta contable
	codigo VARCHAR(11) NOT NULL, 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id), 
	
	-- Integra
	integra VARCHAR(36)  REFERENCES massoftware.CuentaContable (id), 
	
	-- Cuenta de jerarquia
	cuentaJerarquia VARCHAR(11) NOT NULL  CONSTRAINT CuentaContable_cuentaJerarquia_chk CHECK ( char_length(cuentaJerarquia::VARCHAR) >= 11  ), 
	
	-- Imputable
	imputable BOOLEAN NOT NULL, 
	
	-- Ajusta por inflación
	ajustaPorInflacion BOOLEAN NOT NULL, 
	
	-- Estado
	cuentaContableEstado BOOLEAN NOT NULL, 
	
	-- Cuenta con apropiación
	cuentaConApropiacion BOOLEAN NOT NULL, 
	
	-- Centro costo contable
	centroCostoContable VARCHAR(36)  REFERENCES massoftware.CentroCostoContable (id), 
	
	-- Cuenta agrupadora
	cuentaAgrupadora VARCHAR(50), 
	
	-- Porcentaje
	porcentaje DOUBLE PRECISION, 
	
	-- Punto de equilibrio
	puntoEquilibrio VARCHAR(36)  REFERENCES massoftware.PuntoEquilibrio (id), 
	
	-- Costo de venta
	costoVenta VARCHAR(36)  REFERENCES massoftware.CostoVenta (id), 
	
	-- Puerta
	seguridadPuerta VARCHAR(36)  REFERENCES massoftware.SeguridadPuerta (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_CuentaContable_0 ON massoftware.CuentaContable (ejercicioContable, TRANSLATE(LOWER(TRIM(codigo))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

CREATE UNIQUE INDEX u_CuentaContable_1 ON massoftware.CuentaContable (ejercicioContable, TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

CREATE UNIQUE INDEX u_CuentaContable_2 ON massoftware.CuentaContable (ejercicioContable, integra, cuentaJerarquia);

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatCuentaContable() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatCuentaContable() RETURNS TRIGGER AS $formatCuentaContable$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.codigo := massoftware.white_is_null(NEW.codigo);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);
	 NEW.integra := massoftware.white_is_null(NEW.integra);
	 NEW.cuentaJerarquia := massoftware.white_is_null(NEW.cuentaJerarquia);
	 NEW.centroCostoContable := massoftware.white_is_null(NEW.centroCostoContable);
	 NEW.cuentaAgrupadora := massoftware.white_is_null(NEW.cuentaAgrupadora);
	 NEW.puntoEquilibrio := massoftware.white_is_null(NEW.puntoEquilibrio);
	 NEW.costoVenta := massoftware.white_is_null(NEW.costoVenta);
	 NEW.seguridadPuerta := massoftware.white_is_null(NEW.seguridadPuerta);

	RETURN NEW;
END;
$formatCuentaContable$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatCuentaContable ON massoftware.CuentaContable CASCADE;

CREATE TRIGGER tgFormatCuentaContable BEFORE INSERT OR UPDATE
	ON massoftware.CuentaContable FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatCuentaContable();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.CuentaContable;

-- SELECT * FROM massoftware.CuentaContable LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.CuentaContable;

-- SELECT * FROM massoftware.CuentaContable WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: AsientoModelo                                                                                          //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.AsientoModelo

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.AsientoModelo CASCADE;

CREATE TABLE massoftware.AsientoModelo
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº asiento
	numero INTEGER NOT NULL  CONSTRAINT AsientoModelo_numero_chk CHECK ( numero >= 1  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL, 
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_AsientoModelo_0 ON massoftware.AsientoModelo (ejercicioContable, numero);

CREATE UNIQUE INDEX u_AsientoModelo_1 ON massoftware.AsientoModelo (ejercicioContable, TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatAsientoModelo() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatAsientoModelo() RETURNS TRIGGER AS $formatAsientoModelo$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);

	RETURN NEW;
END;
$formatAsientoModelo$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatAsientoModelo ON massoftware.AsientoModelo CASCADE;

CREATE TRIGGER tgFormatAsientoModelo BEFORE INSERT OR UPDATE
	ON massoftware.AsientoModelo FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatAsientoModelo();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.AsientoModelo;

-- SELECT * FROM massoftware.AsientoModelo LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.AsientoModelo;

-- SELECT * FROM massoftware.AsientoModelo WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: AsientoModeloItem                                                                                      //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.AsientoModeloItem

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.AsientoModeloItem CASCADE;

CREATE TABLE massoftware.AsientoModeloItem
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº item
	numero INTEGER NOT NULL  CONSTRAINT AsientoModeloItem_numero_chk CHECK ( numero >= 1  ), 
	
	-- Asiento modelo
	asientoModelo VARCHAR(36)  NOT NULL  REFERENCES massoftware.AsientoModelo (id), 
	
	-- Cuenta contable
	cuentaContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.CuentaContable (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_AsientoModeloItem_0 ON massoftware.AsientoModeloItem (asientoModelo, numero);

CREATE UNIQUE INDEX u_AsientoModeloItem_1 ON massoftware.AsientoModeloItem (asientoModelo, cuentaContable);

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatAsientoModeloItem() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatAsientoModeloItem() RETURNS TRIGGER AS $formatAsientoModeloItem$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.asientoModelo := massoftware.white_is_null(NEW.asientoModelo);
	 NEW.cuentaContable := massoftware.white_is_null(NEW.cuentaContable);

	RETURN NEW;
END;
$formatAsientoModeloItem$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatAsientoModeloItem ON massoftware.AsientoModeloItem CASCADE;

CREATE TRIGGER tgFormatAsientoModeloItem BEFORE INSERT OR UPDATE
	ON massoftware.AsientoModeloItem FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatAsientoModeloItem();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.AsientoModeloItem;

-- SELECT * FROM massoftware.AsientoModeloItem LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.AsientoModeloItem;

-- SELECT * FROM massoftware.AsientoModeloItem WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: MinutaContable                                                                                         //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.MinutaContable

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.MinutaContable CASCADE;

CREATE TABLE massoftware.MinutaContable
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº minuta
	numero INTEGER NOT NULL  CONSTRAINT MinutaContable_numero_chk CHECK ( numero >= 0  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_MinutaContable_0 ON massoftware.MinutaContable (numero);

CREATE UNIQUE INDEX u_MinutaContable_1 ON massoftware.MinutaContable (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatMinutaContable() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatMinutaContable() RETURNS TRIGGER AS $formatMinutaContable$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatMinutaContable$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatMinutaContable ON massoftware.MinutaContable CASCADE;

CREATE TRIGGER tgFormatMinutaContable BEFORE INSERT OR UPDATE
	ON massoftware.MinutaContable FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatMinutaContable();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.MinutaContable;

-- SELECT * FROM massoftware.MinutaContable LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.MinutaContable;

-- SELECT * FROM massoftware.MinutaContable WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: AsientoContableModulo                                                                                  //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.AsientoContableModulo

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.AsientoContableModulo CASCADE;

CREATE TABLE massoftware.AsientoContableModulo
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº módulo
	numero INTEGER NOT NULL  CONSTRAINT AsientoContableModulo_numero_chk CHECK ( numero >= 0  ), 
	
	-- Nombre
	nombre VARCHAR(50) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_AsientoContableModulo_0 ON massoftware.AsientoContableModulo (numero);

CREATE UNIQUE INDEX u_AsientoContableModulo_1 ON massoftware.AsientoContableModulo (TRANSLATE(LOWER(TRIM(nombre))
	, '/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ'
	, '         aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN' ));

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatAsientoContableModulo() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatAsientoContableModulo() RETURNS TRIGGER AS $formatAsientoContableModulo$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.nombre := massoftware.white_is_null(NEW.nombre);

	RETURN NEW;
END;
$formatAsientoContableModulo$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatAsientoContableModulo ON massoftware.AsientoContableModulo CASCADE;

CREATE TRIGGER tgFormatAsientoContableModulo BEFORE INSERT OR UPDATE
	ON massoftware.AsientoContableModulo FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatAsientoContableModulo();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.AsientoContableModulo;

-- SELECT * FROM massoftware.AsientoContableModulo LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.AsientoContableModulo;

-- SELECT * FROM massoftware.AsientoContableModulo WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: AsientoContable                                                                                        //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.AsientoContable

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.AsientoContable CASCADE;

CREATE TABLE massoftware.AsientoContable
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº asiento
	numero INTEGER NOT NULL  CONSTRAINT AsientoContable_numero_chk CHECK ( numero >= 1  ), 
	
	-- Fecha
	fecha DATE NOT NULL, 
	
	-- Detalle
	detalle VARCHAR(100), 
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id), 
	
	-- Minuta contable
	minutaContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.MinutaContable (id), 
	
	-- Sucursal
	sucursal VARCHAR(36)  NOT NULL  REFERENCES massoftware.Sucursal (id), 
	
	-- Módulo
	asientoContableModulo VARCHAR(36)  NOT NULL  REFERENCES massoftware.AsientoContableModulo (id)
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_AsientoContable_0 ON massoftware.AsientoContable (ejercicioContable, numero);

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatAsientoContable() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatAsientoContable() RETURNS TRIGGER AS $formatAsientoContable$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.detalle := massoftware.white_is_null(NEW.detalle);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);
	 NEW.minutaContable := massoftware.white_is_null(NEW.minutaContable);
	 NEW.sucursal := massoftware.white_is_null(NEW.sucursal);
	 NEW.asientoContableModulo := massoftware.white_is_null(NEW.asientoContableModulo);

	RETURN NEW;
END;
$formatAsientoContable$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatAsientoContable ON massoftware.AsientoContable CASCADE;

CREATE TRIGGER tgFormatAsientoContable BEFORE INSERT OR UPDATE
	ON massoftware.AsientoContable FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatAsientoContable();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.AsientoContable;

-- SELECT * FROM massoftware.AsientoContable LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.AsientoContable;

-- SELECT * FROM massoftware.AsientoContable WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: AsientoContableItem                                                                                    //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.AsientoContableItem

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.AsientoContableItem CASCADE;

CREATE TABLE massoftware.AsientoContableItem
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Nº item
	numero INTEGER NOT NULL  CONSTRAINT AsientoContableItem_numero_chk CHECK ( numero >= 1  ), 
	
	-- Fecha
	fecha DATE NOT NULL, 
	
	-- Detalle
	detalle VARCHAR(100), 
	
	-- Asiento contable
	asientoContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.AsientoContable (id), 
	
	-- Cuenta contable
	cuentaContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.CuentaContable (id), 
	
	-- Debe
	debe DECIMAL(13,5) NOT NULL, 
	
	-- Haber
	haber DECIMAL(13,5) NOT NULL
);

-- ---------------------------------------------------------------------------------------------------------------------------


CREATE UNIQUE INDEX u_AsientoContableItem_0 ON massoftware.AsientoContableItem (asientoContable, numero);

-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatAsientoContableItem() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatAsientoContableItem() RETURNS TRIGGER AS $formatAsientoContableItem$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.detalle := massoftware.white_is_null(NEW.detalle);
	 NEW.asientoContable := massoftware.white_is_null(NEW.asientoContable);
	 NEW.cuentaContable := massoftware.white_is_null(NEW.cuentaContable);

	RETURN NEW;
END;
$formatAsientoContableItem$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatAsientoContableItem ON massoftware.AsientoContableItem CASCADE;

CREATE TRIGGER tgFormatAsientoContableItem BEFORE INSERT OR UPDATE
	ON massoftware.AsientoContableItem FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatAsientoContableItem();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.AsientoContableItem;

-- SELECT * FROM massoftware.AsientoContableItem LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.AsientoContableItem;

-- SELECT * FROM massoftware.AsientoContableItem WHERE id = 'xxx';

-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- //                                                                                                                        //
-- //          TABLA: Empresa                                                                                                //
-- //                                                                                                                        //
-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


-- Table: massoftware.Empresa

-- ---------------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS massoftware.Empresa CASCADE;

CREATE TABLE massoftware.Empresa
(
	id VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
	
	-- Ejercicio
	ejercicioContable VARCHAR(36)  NOT NULL  REFERENCES massoftware.EjercicioContable (id), 
	
	-- Fecha cierre ventas
	fechaCierreVentas DATE, 
	
	-- Fecha cierre stock
	fechaCierreStock DATE, 
	
	-- Fecha cierre fondo
	fechaCierreFondo DATE, 
	
	-- Fecha cierre compras
	fechaCierreCompras DATE, 
	
	-- Fecha cierre contabilidad
	fechaCierreContabilidad DATE, 
	
	-- Fecha cierre garantia y devoluciones
	fechaCierreGarantiaDevoluciones DATE, 
	
	-- Fecha cierre tambos
	fechaCierreTambos DATE, 
	
	-- Fecha cierre RRHH
	fechaCierreRRHH DATE
);

-- ---------------------------------------------------------------------------------------------------------------------------


-- ---------------------------------------------------------------------------------------------------------------------------

DROP FUNCTION IF EXISTS massoftware.ftgFormatEmpresa() CASCADE;

CREATE OR REPLACE FUNCTION massoftware.ftgFormatEmpresa() RETURNS TRIGGER AS $formatEmpresa$
DECLARE
BEGIN
	 NEW.id := massoftware.white_is_null(NEW.id);
	 NEW.ejercicioContable := massoftware.white_is_null(NEW.ejercicioContable);

	RETURN NEW;
END;
$formatEmpresa$ LANGUAGE plpgsql;

-- ---------------------------------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS tgFormatEmpresa ON massoftware.Empresa CASCADE;

CREATE TRIGGER tgFormatEmpresa BEFORE INSERT OR UPDATE
	ON massoftware.Empresa FOR EACH ROW
	EXECUTE PROCEDURE massoftware.ftgFormatEmpresa();

-- ---------------------------------------------------------------------------------------------------------------------------


-- SELECT COUNT(*) FROM massoftware.Empresa;

-- SELECT * FROM massoftware.Empresa LIMIT 100 OFFSET 0;

-- SELECT * FROM massoftware.Empresa;

-- SELECT * FROM massoftware.Empresa WHERE id = 'xxx';
