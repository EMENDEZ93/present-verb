  insert into usuario
	(
	ID,
	ID_FIREBASE,
	CORREO
	)
  values {
    (1, 'IdFirebase01', 'testing01@em.com.co'),
    (2, 'IdFirebase02', 'testing02@em.com.co'),
    (3, 'IdFirebase03', 'testing03@em.com.co')
   };

  insert into excel
	(
	ID,
	NOMBRE,
	USUARIO_ID
	)
  values {(1, 'excel.lxs', 1), (2, 'excel1.lxs', 1)};

  insert into hoja
	(
	ID,
	NOMBRE,
	EXCEL_ID,
	ES_PREGUNTA_RESPUESTA,
	FILAS,
	INDICE_EXCEL,
	NUMERO_VERBOS_POR_APRENDER_DIARIO,
	REPETICIONES_ALTA_COMO_APRENDIDO,
	ULTIMO_INDICE_APRENDIDO,
	ULTIMA_FECHA_APRENDIO,
	ULTIMA_FECHA_RUTINA
	)
  values {
    (1, 'hojaA.lxs', 1, FALSE, 88, 11, 10, 3, 5, '2021-07-21', '2021-06-21'),
    (2, 'hojaB.lxs', 1, FALSE, 99, 22, 5, 4, 10, '2021-08-21', '2021-05-21'),
    (3, 'hojaC.lxs', 2, FALSE, 77, 33, 5, 8, 20, '2021-08-21', '2021-04-21')
   };


  insert into perfil
	(
	ID,
	ID_FIREBASE,
	CORREO,
	NUMERO_VERBOS_POR_APRENDER_DIARIO,
	REPETICIONES_ALTA_COMO_APRENDIDO,
	ULTIMO_INDICE_APRENDIDO
	)
  values {
    (1, 'IdFirebasePerfil01', 'perfil01@em.com.co', 5, 5, 0),
    (2, 'IdFirebasePerfil02', 'perfil02@em.com.co', 5, 5, 0),
    (3, 'IdFirebasePerfil03', 'perfil03@em.com.co', 5, 5, 0)
   };

  insert into temas
	(
	ID,
	NOMBRE,
	PERFIL_ID,
	ES_PREGUNTA_RESPUESTA,
	FILAS,
	INDICE_EXCEL,
	NUMERO_VERBOS_POR_APRENDER_DIARIO,
	REPETICIONES_ALTA_COMO_APRENDIDO,
	ULTIMO_INDICE_APRENDIDO,
	ULTIMA_FECHA_APRENDIO,
	ULTIMA_FECHA_RUTINA
	)
  values {
    (1, 'tema1', 1, FALSE, 88, 11, 10, 3, 5, '2021-07-21', '2021-06-21'),
    (2, 'tema2', 1, FALSE, 99, 22, 5, 4, 10, '2021-08-21', '2021-05-21'),
    (3, 'tema3', 2, FALSE, 77, 33, 5, 8, 20, '2021-08-21', '2021-04-21')
   };
