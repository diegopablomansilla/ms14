SELECT	Sucursal.id AS id_0
		
	, Sucursal_0.numero AS numero_1
	, Sucursal_0.nombre AS nombre_2
	, Sucursal_0.abreviatura AS abreviatura_3
	, Sucursal_0.tipoSucursal AS tipoSucursal_4
	, Sucursal_0.cuentaClientesDesde AS cuentaClientesDesde_5
	, Sucursal_0.cuentaClientesHasta AS cuentaClientesHasta_6
	, Sucursal_0.cantidadCaracteresClientes AS cantidadCaracteresClientes_7
	, Sucursal_0.identificacionNumericaClientes AS identificacionNumericaClientes_8
	, Sucursal_0.permiteCambiarClientes AS permiteCambiarClientes_9
	, Sucursal_0.cuentaProveedoresDesde AS cuentaProveedoresDesde_10
	, Sucursal_0.cuentaProveedoresHasta AS cuentaProveedoresHasta_11
	, Sucursal_0.cantidadCaracteresProveedores AS cantidadCaracteresProveedores_12
	, Sucursal_0.identificacionNumericaProveedores AS identificacionNumericaProveedores_13
	, Sucursal_0.permiteCambiarProveedores AS permiteCambiarProveedores_14
	, Sucursal_0.clientesOcacionalesDesde AS clientesOcacionalesDesde_15
	, Sucursal_0.clientesOcacionalesHasta AS clientesOcacionalesHasta_16
	, Sucursal_0.numeroCobranzaDesde AS numeroCobranzaDesde_17
	, Sucursal_0.numeroCobranzaHasta AS numeroCobranzaHasta_18
FROM	massoftware.Sucursal AS Sucursal_0 

${WHERE}
${ORDER_BY}
${PAGE}