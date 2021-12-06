  insert into usuario
	(
	ID,
	ID_FIREBASE,
	CORREO
	)
  values {
    (1, 'IdFirebase01', 'testing01@em.com.co'),
    (2, 'IdFirebase02', 'testing02@em.com.co'),
    (3, 'IdFirebase03', 'testing03@em.com.co'),
    (6, 'IdFirebase04', 'testing04@em.com.co'),
    (10, 'IdFirebase10', 'testing10@em.com.co'),
    (11, 'IdFirebase11', 'testing11@em.com.co'),
    (15, 'IdFirebase12', 'testing12@em.com.co'),
    (16, 'IdFirebase13', 'testing13@em.com.co')
   };

  insert into excel
	(
	ID,
	NOMBRE,
	ARCHIVO,
	USUARIO_ID,
	CANTIDADHOJAS_POR_RUTINA,
	ULTIMO_INDICE_REPASO,
	ACTUALIZACION_INDICE_REPASO,
	REPETICION_POR_HORAS,
	HORA_ACTUALIZACION_INDICE_REPASO
	)
  values {
    (1, 'excel.lxs', 'excel', 1, 0, 0, '2021-06-21', 12, 10),
    (2, 'excel1', 'excel1.lxs', 1, 0, 0, '2021-06-21', 12, 10),
    (3, 'ejemplo1.xlsx','ejemplo1.xlsx', 6, 0, 0, '2021-06-21', 12, 10),
    (4, 'ejemplo3.xlsx','ejemplo3.xlsx', 6, 0, 0, '2021-06-21', 12, 10),
    (5, 'ejemplo2.xlsx','ejemplo2.xlsx', 6, 0, 0, '2021-06-21', 12, 10),
    (10, 'excelnoesfisico.xlsx','excelnoesfisico.xlsx', 10, 5, null, '2021-06-21', 12, 10),
    (11, 'excelnoesfisico.xlsx','excelnoesfisico.xlsx', 11, 5, 13, '2021-06-21', 12, 10),
    (12, 'excelnoesfisico.xlsx','excelnoesfisico.xlsx', 15, 5, 14, '2021-06-21', 12, 10),
    (13, 'excelnoesfisico.xlsx','excelnoesfisico.xlsx', 16, 5, 5, '2021-06-21', 12, 10)
   };

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
	ULTIMA_FECHA_RUTINA,
	POR_RUTINA
	)
  values {
    (1, 'hojaA.lxs', 1, FALSE, 88, 11, 10, 3, 5, '2021-07-21', '2021-06-21', FALSE),
    (2, 'hojaB.lxs', 1, FALSE, 99, 22, 5, 4, 10, '2021-08-21', '2021-05-21', FALSE),
    (3, 'hojaC.lxs', 2, FALSE, 77, 33, 5, 8, 20, '2021-08-21', '2021-04-21', FALSE),
    (6, 'hojaejemplo11', 3, FALSE, 80, 1, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),
    (7, 'hojaejemplo33', 3, FALSE, 80, 1, 5, 8, 1, '2021-09-21', '2021-09-21', FALSE),
    (8, 'hojaejemplo11', 3, FALSE, 80, 1, 5, 8, 4, '2021-09-21', '2021-09-21', FALSE),
    (9, 'hojaejemplo22', 5, FALSE, 80, 1, 5, 8, 4, '2021-09-21', '2021-09-21', FALSE),

    (10, 'noexistehoja1', 10, FALSE, 80, 1, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (11, 'noexistehoja2', 10, FALSE, 80, 2, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (12, 'noexistehoja3', 10, FALSE, 80, 3, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (13, 'noexistehoja4', 10, FALSE, 80, 4, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (14, 'noexistehoja5', 10, FALSE, 80, 5, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (15, 'noexistehoja6', 10, FALSE, 80, 6, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (16, 'noexistehoja7', 10, FALSE, 80, 7, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (17, 'noexistehoja8', 10, FALSE, 80, 8, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (18, 'noexistehoja9', 10, FALSE, 80, 9, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (19, 'noexistehoja10', 10, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (20, 'noexistehoja11', 10, FALSE, 80, 10, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),
    (21, 'noexistehoja12', 10, FALSE, 80, 10, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),
    (22, 'noexistehoja13', 10, FALSE, 80, 10, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),
    (23, 'noexistehoja14', 10, FALSE, 80, 10, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),
    (24, 'noexistehoja15', 10, FALSE, 80, 10, 5, 8, 0, '2021-09-21', '2021-09-21', FALSE),

    (25, 'noexistehoja1', 11, FALSE, 80, 1, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (26, 'noexistehoja2', 11, FALSE, 80, 2, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (27, 'noexistehoja3', 11, FALSE, 80, 3, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (28, 'noexistehoja4', 11, FALSE, 80, 4, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (29, 'noexistehoja5', 11, FALSE, 80, 5, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (30, 'noexistehoja6', 11, FALSE, 80, 6, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (31, 'noexistehoja7', 11, FALSE, 80, 7, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (32, 'noexistehoja8', 11, FALSE, 80, 8, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (33, 'noexistehoja9', 11, FALSE, 80, 9, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (34, 'noexistehoja10', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (35, 'noexistehoja11', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (36, 'noexistehoja12', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (37, 'noexistehoja13', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (38, 'noexistehoja14', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (39, 'noexistehoja15', 11, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),

    (40, 'noexistehoja1', 12, FALSE, 80, 1, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (41, 'noexistehoja2', 12, FALSE, 80, 2, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (42, 'noexistehoja3', 12, FALSE, 80, 3, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (43, 'noexistehoja4', 12, FALSE, 80, 4, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (44, 'noexistehoja5', 12, FALSE, 80, 5, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (45, 'noexistehoja6', 12, FALSE, 80, 6, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (46, 'noexistehoja7', 12, FALSE, 80, 7, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (47, 'noexistehoja8', 12, FALSE, 80, 8, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (48, 'noexistehoja9', 12, FALSE, 80, 9, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (49, 'noexistehoja10', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (50, 'noexistehoja11', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (51, 'noexistehoja12', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (52, 'noexistehoja13', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (53, 'noexistehoja14', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (54, 'noexistehoja15', 12, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),

    (55, 'noexistehoja1', 13, FALSE, 80, 1, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (56, 'noexistehoja2', 13, FALSE, 80, 2, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (57, 'noexistehoja3', 13, FALSE, 80, 3, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (58, 'noexistehoja4', 13, FALSE, 80, 4, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (59, 'noexistehoja5', 13, FALSE, 80, 5, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (60, 'noexistehoja6', 13, FALSE, 80, 6, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (61, 'noexistehoja7', 13, FALSE, 80, 7, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (62, 'noexistehoja8', 13, FALSE, 80, 8, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (63, 'noexistehoja9', 13, FALSE, 80, 9, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (64, 'noexistehoja10', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (65, 'noexistehoja11', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (66, 'noexistehoja12', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (67, 'noexistehoja13', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (68, 'noexistehoja14', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (69, 'noexistehoja15', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE),
    (70, 'noexistehoja15', 13, FALSE, 80, 10, 5, 8, 5, '2021-09-21', '2021-09-21', FALSE)

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
