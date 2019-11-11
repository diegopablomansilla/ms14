SELECT	CuentaContable_0.id AS id_0
		
	, CuentaContable_0.codigo AS codigo_1
	, CuentaContable_0.nombre AS nombre_2
	, CuentaContable_0.ejercicioContable AS ejercicioContable_3
	, CuentaContable_0.integra AS integra_4
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
	, CuentaContable_0.puntoEquilibrio AS puntoEquilibrio_13
	, CuentaContable_0.costoVenta AS costoVenta_14
	, CuentaContable_0.seguridadPuerta AS seguridadPuerta_15
FROM	massoftware.CuentaContable AS CuentaContable_0
LEFT JOIN massoftware.CentroCostoContable AS CentroCostoContable_0 ON  CentroCostoContable_0.id = CuentaContable_0.centroCostoContable

${WHERE}
${ORDER_BY}
${PAGE}