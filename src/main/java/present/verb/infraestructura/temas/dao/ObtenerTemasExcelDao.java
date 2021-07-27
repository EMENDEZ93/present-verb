package present.verb.infraestructura.temas.dao;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import present.verb.aplicacion.palabras.TemaDto;
import present.verb.dominio.temas.puerto.dao.ObtenerTemasV1Dao;
import present.verb.dominio.perfil.modelo.Perfil;
import present.verb.dominio.perfil.puerto.repositorio.PerfilRepositorio;
import present.verb.infraestructura.comun.dao.exception.DaoException;

@Repository
public class ObtenerTemasExcelDao implements ObtenerTemasV1Dao {

	public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
	public static final int VERB_SHEET = 0;

	@Autowired
	private PerfilRepositorio perfilRepositorio;

	@Override
	public List<TemaDto> ejecutar(String correo) {
		return obtener(correo);
	}

	@Override
	public List<TemaDto> ejecutar() {
		return obtener();
	}

	public List<TemaDto> obtener(String correo) {
		try {
			Perfil perfil = perfilRepositorio.getByCorreo(correo);
			return perfil.getTemas()
					.stream()
					.map(temas1 -> new TemaDto(temas1.getNombre(), temas1.getRealizadoRutinaHoy()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

	public List<TemaDto> obtener() {
		try {
			List<TemaDto> temas = new ArrayList<>();

			InputStream in = getClass().getResourceAsStream("/present_verb.xlsx");
			XSSFWorkbook excel = new XSSFWorkbook (in);

			for (int i = 0; i < excel.getNumberOfSheets(); i++) {
				TemaDto temaDto = new TemaDto();
				temaDto.setTema(excel.getSheetName(i));
				temaDto.setRealizadoHoy(false);
				temas.add(temaDto);
			}

			return temas;

		} catch (Exception e) {
			throw new RuntimeException("Error al trata de leer el xlxs : " + e.getMessage() );
		}
	}

}
