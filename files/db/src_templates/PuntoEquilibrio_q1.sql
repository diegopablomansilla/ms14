SELECT	PuntoEquilibrio_0.id AS id_0
		
	, PuntoEquilibrio_0.numero AS numero_1
	, PuntoEquilibrio_0.nombre AS nombre_2
	
--	, PuntoEquilibrio_0.tipoPuntoEquilibrio AS tipoPuntoEquilibrio_3
	, TipoPuntoEquilibrio_0.id AS TipoPuntoEquilibrio_0_id_0		
	, TipoPuntoEquilibrio_0.numero AS TipoPuntoEquilibrio_0_numero_1
	, TipoPuntoEquilibrio_0.nombre AS TipoPuntoEquilibrio_0_nombre_2	
	
	, PuntoEquilibrio_0.ejercicioContable AS ejercicioContable_4
	
FROM	massoftware.PuntoEquilibrio AS PuntoEquilibrio_0
LEFT JOIN massoftware.TipoPuntoEquilibrio AS TipoPuntoEquilibrio_0 ON  TipoPuntoEquilibrio_0.id = PuntoEquilibrio_0.tipoPuntoEquilibrio

${WHERE}
${ORDER_BY}
${PAGE}