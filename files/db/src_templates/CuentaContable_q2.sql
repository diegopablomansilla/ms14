SELECT	CuentaContable_0.id AS id_0
		
	, CuentaContable_0.codigo AS codigo_1
	, CuentaContable_0.nombre AS nombre_2
	
	, CuentaContable_0.ejercicioContable AS ejercicioContable_3 -- FK
	
	, CuentaContable_0.integra AS integra_4 -- FK
	
	, CuentaContable_0.cuentaJerarquia AS cuentaJerarquia_5
	, CuentaContable_0.imputable AS imputable_6
	, CuentaContable_0.ajustaPorInflacion AS ajustaPorInflacion_7
	, CuentaContable_0.cuentaContableEstado AS cuentaContableEstado_8
	, CuentaContable_0.cuentaConApropiacion AS cuentaConApropiacion_9
	
	--, CuentaContable_0.centroCostoContable AS centroCostoContable_10
	, CentroCostoContable_0.id AS CentroCostoContable_0_id_0		
	, CentroCostoContable_0.numero AS CentroCostoContable_0_numero_1
	, CentroCostoContable_0.nombre AS CentroCostoContable_0_nombre_2
	, CentroCostoContable_0.abreviatura AS CentroCostoContable_0_abreviatura_3
	, CentroCostoContable_0.ejercicioContable AS CentroCostoContable_0_ejercicioContable_4
	
	, CuentaContable_0.cuentaAgrupadora AS cuentaAgrupadora_11
	, CuentaContable_0.porcentaje AS porcentaje_12
	
	--, CuentaContable_0.puntoEquilibrio AS puntoEquilibrio_13
	, PuntoEquilibrio_0.id AS PuntoEquilibrio_0_id_0		
	, PuntoEquilibrio_0.numero AS PuntoEquilibrio_0_numero_1
	, PuntoEquilibrio_0.nombre AS PuntoEquilibrio_0_nombre_2
	, PuntoEquilibrio_0.tipoPuntoEquilibrio AS PuntoEquilibrio_0_tipoPuntoEquilibrio_3
	, PuntoEquilibrio_0.ejercicioContable AS PuntoEquilibrio_0_ejercicioContable_4
	
	--, CuentaContable_0.costoVenta AS costoVenta_14
	, CostoVenta_0.id AS CostoVenta_0_id_0		
	, CostoVenta_0.numero AS CostoVenta_0_numero_1
	, CostoVenta_0.nombre AS CostoVenta_0_nombre_2
	
	--, CuentaContable_0.seguridadPuerta AS seguridadPuerta_15
	, SeguridadPuerta_0.id AS SeguridadPuerta_0_id_0		
	, SeguridadPuerta_0.numero AS SeguridadPuerta_0_numero_1
	, SeguridadPuerta_0.nombre AS SeguridadPuerta_0_nombre_2
	, SeguridadPuerta_0.equate AS SeguridadPuerta_0_equate_3
	, SeguridadPuerta_0.seguridadModulo AS SeguridadPuerta_0_seguridadModulo_4
	
FROM	massoftware.CuentaContable AS CuentaContable_0
LEFT JOIN massoftware.CentroCostoContable AS CentroCostoContable_0 ON  CentroCostoContable_0.id = CuentaContable_0.centroCostoContable
LEFT JOIN massoftware.PuntoEquilibrio AS PuntoEquilibrio_0  ON PuntoEquilibrio_0.id = CuentaContable_0.puntoEquilibrio
LEFT JOIN massoftware.CostoVenta AS CostoVenta_0  ON CostoVenta_0.id = CuentaContable_0.costoVenta
LEFT JOIN massoftware.SeguridadPuerta AS SeguridadPuerta_0 ON SeguridadPuerta_0.id = CuentaContable_0.seguridadPuerta

${WHERE}
