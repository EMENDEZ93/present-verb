package present.verb.palabras.infraestructura.dao.temas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import present.verb.palabras.aplicacion.consulta.manejador.TemaDto;
import present.verb.palabras.dominio.dao.temas.ObtenerTemasV1Dao;
import present.verb.perfil.dominio.entidad.Perfil;
import present.verb.perfil.dominio.entidad.Temas;
import present.verb.perfil.dominio.repositorio.PerfilRepositorio;

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
			List<TemaDto> temas = new ArrayList<>();

			File myFile = new File(Paths.get("").toAbsolutePath().toString() + VERB_FILE);
			FileInputStream fis = null;			fis = new FileInputStream(myFile); // Finds the workbook instance for XLSX file XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
			XSSFWorkbook excel = new XSSFWorkbook (fis);

			Perfil perfil = perfilRepositorio.findByCorreo(correo);
			List<Temas> temasList = perfil.getTemas();

			for (int i = 0; i < excel.getNumberOfSheets(); i++) {
				TemaDto temaDto = new TemaDto();
				temaDto.setTema(excel.getSheetName(i));


				Optional<Temas> t = temasList.stream().filter(temas1 -> temas1.getNombre().equals(temaDto.getTema())).findFirst();

				LocalDate ultimaFechaAprendio = t.get().getUltimaFechaAprendio();

				LocalDate ahora = LocalDate.now();

				temaDto.setRealizadoHoy(ultimaFechaAprendio.isAfter(LocalDate.now()) || ultimaFechaAprendio.isEqual(LocalDate.now()));

				temas.add(temaDto);
			}

			return temas;
		} catch (Exception e) {
			throw new RuntimeException("Error al trata de leer el xlxs : ".concat(e.getMessage()));
		}

	}

	public List<TemaDto> obtener() {
		try {
			List<TemaDto> temas = new ArrayList<>();
			File myFile = new File(Paths.get("").toAbsolutePath().toString() + VERB_FILE);
			FileInputStream fis = null;			fis = new FileInputStream(myFile); // Finds the workbook instance for XLSX file XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
			XSSFWorkbook excel = new XSSFWorkbook (fis);
			//OPCPackage file = obtenerArchivo();
			//XSSFWorkbook excel = creacionWorkBook(file);

			for (int i = 0; i < excel.getNumberOfSheets(); i++) {
				TemaDto temaDto = new TemaDto();
				temaDto.setTema(excel.getSheetName(i));
				temaDto.setRealizadoHoy(false);
				temas.add(temaDto);
			}

			return temas;

		} catch (Exception e) {
			throw new RuntimeException("Error al trata de leer el xlxs : ".concat(e.getMessage()));
		}
	}


	private XSSFWorkbook creacionWorkBook(OPCPackage file) {
		try {
			return new XSSFWorkbook(file);
		} catch (IOException e1) {
		}
		return null;
	}

//	private OPCPackage obtenerArchivo() {
//		try {
//			return OPCPackage.open(new File(Paths.get("").toAbsolutePath().toString() + VERB_FILE));
//		} catch (InvalidFormatException e1) {
//		}
//		return null;
//	}

}
