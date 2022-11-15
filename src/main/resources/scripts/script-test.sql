INSERT INTO public.programacion_linea(
	id_programacion, fec_creacion, equipo_creacion, equipo_actualizacion, fec_actualizacion, usu_creacion, usu_actualizacion, fecha_programacion, flg_anulado, hora_final, hora_inicio, id_centro, id_estado_programacion, id_linea, version)
	VALUES (1, '2022-06-21T00:00:00', 'eq1', 'eq1', '2022-06-21T00:00:00', 'usu1', 'usu1', '2022-06-21T00:00:00', false, '2022-06-21T00:00:00', '2022-06-21T00:00:00', 'cent', 'activo', 1, 'v10');

INSERT INTO public.supervisor(
	nombre, cod_supervisor, abrev, fec_creacion, equipo_creacion, equipo_actualizacion, fec_actualizacion, usu_creacion, usu_actualizacion, flg_anulado)
	VALUES ('Diego', 1, 'DK', '2022-06-21T00:00:00', 'eq1', 'eq2', '2022-06-21T00:00:00', 'usu1', 'usu1', false);

INSERT INTO public.turno(
	cod_turno, flg_anulado, hora_fin, hora_inicio, sec, turno)
	VALUES ('A', false, '2022-06-21T00:00:00', '2022-06-21T00:00:00', 1, 'AM');

INSERT INTO public.programacion_turno_material(
	id_material, id_programacion, cod_turno, fec_creacion, equipo_creacion, equipo_actualizacion, fec_actualizacion, usu_creacion, usu_actualizacion, cod_carga_data, fecha_contabilizacion, fecha_documento, fecha_produccion, fecha_vencimiento, flg_anulado, hora_final, hora_inicio, id_estado_programacion, ingreso, minutos_just, produccion, teorico, tiempo_cnv, tiempo_pnp, tiempo_pp, tiempo_td, tiempo_ttt, velocidad, id_supervisor)
	VALUES (1, 1, 'A', '2022-06-21T00:00:00', 'eq1', 'eq2', '2022-06-21T00:00:00', 'usu1', 'usu1', 'cod_carga_data', '2022-06-21T00:00:00', '2022-06-21T00:00:00', '2022-06-21T00:00:00', '2022-06-21T00:00:00', false, '2022-06-21T00:00:00', '2022-06-21T00:00:00', 'ID', 1, 1, 1, 'teorico', 1, 1, 1, 1, 1, 1, 1);