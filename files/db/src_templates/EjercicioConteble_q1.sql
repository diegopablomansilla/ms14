SELECT	id
		, numero
		, apertura	
		, cierre
		, cerrado
		, cerradoModulos
		, comentario
FROM	massoftware.EjercicioContable
${WHERE}
${ORDER_BY}
${PAGE}