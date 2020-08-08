package present.verb.palabras.infraestructura.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import present.verb.palabras.dominio.dao.ObtenerTemasDao;

@Repository
public class ObtenerTemasExcelDao implements ObtenerTemasDao {

	public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
	public static final int VERB_SHEET = 0;		
	
	@Override
	public List<String> ejecutar() {
		return obtener();
	}

	public List<String> obtener() {

		List<String> temas = new ArrayList<>();
		
		OPCPackage file = obtenerArchivo();
		XSSFWorkbook excel = creacionWorkBook(file);

		for (int i = 0; i < excel.getNumberOfSheets(); i++) {
			temas.add( excel.getSheetName(i) );
		}
				
		return temas;
	}
	
	private XSSFWorkbook creacionWorkBook(OPCPackage file) {
		try {
			return new XSSFWorkbook(file);
		} catch (IOException e1) {
		}
		return null;
	}

	private OPCPackage obtenerArchivo() {
		try {
			return OPCPackage.open(new File(Paths.get("").toAbsolutePath().toString() + VERB_FILE));
		} catch (InvalidFormatException e1) {
		}
		return null;
	}
	
}
