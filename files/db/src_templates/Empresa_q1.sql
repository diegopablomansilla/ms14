SELECT	Empresa_0.id AS id_0
		
	, EjercicioContable_0.id AS EjercicioContable_0_id_0		
	, EjercicioContable_0.numero AS EjercicioContable_0_numero_1
	, EjercicioContable_0.apertura AS EjercicioContable_0_apertura_2
	, EjercicioContable_0.cierre AS EjercicioContable_0_cierre_3
	, EjercicioContable_0.cerrado AS EjercicioContable_0_cerrado_4
	, EjercicioContable_0.cerradoModulos AS EjercicioContable_0_cerradoModulos_5
	, EjercicioContable_0.comentario AS EjercicioContable_0_comentario_6	
	
	, Empresa_0.fechaCierreVentas AS fechaCierreVentas_2
	, Empresa_0.fechaCierreStock AS fechaCierreStock_3
	, Empresa_0.fechaCierreFondo AS fechaCierreFondo_4
	, Empresa_0.fechaCierreCompras AS fechaCierreCompras_5
	, Empresa_0.fechaCierreContabilidad AS fechaCierreContabilidad_6
	, Empresa_0.fechaCierreGarantiaDevoluciones AS fechaCierreGarantiaDevoluciones_7
	, Empresa_0.fechaCierreTambos AS fechaCierreTambos_8
	, Empresa_0.fechaCierreRRHH AS fechaCierreRRHH_9		
	
FROM	massoftware.Empresa AS Empresa_0
JOIN 	massoftware.EjercicioContable AS EjercicioContable_0 ON EjercicioContable_0.id = Empresa_0.ejercicioContable 	 

${WHERE}
${ORDER_BY}
${PAGE}