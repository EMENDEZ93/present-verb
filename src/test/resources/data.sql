  insert into perfil
	(
	CORREO,
	NUMERO_VERBOS_POR_APRENDER_DIARIO,
	REPETICIONES_ALTA_COMO_APRENDIDO,
	ULTIMO_INDICE_APRENDIDO
	)
  values {('testing01@em.com.co', 5, 5, 3), ('testing02@em.com.co', 5, 5, 3)};

  insert into temas
	(
	NOMBRE,
	ULTIMO_INDICE_APRENDIDO,
	REPETICIONES_ALTA_COMO_APRENDIDO,
	NUMERO_VERBOS_POR_APRENDER_DIARIO,
	PERFIL_ID,
	ES_PREGUNTA_RESPUESTA,
    ULTIMA_FECHA_APRENDIO
	)
  values {('Tema Tesing 01', 5, 5, 3, 2, false, '2021-07-23'), ('Tema Tesing 02', 5, 5, 3, 2, false, '2021-07-21')};