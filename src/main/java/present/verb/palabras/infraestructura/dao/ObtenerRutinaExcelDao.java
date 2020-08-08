package present.verb.palabras.infraestructura.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;

import present.verb.palabras.dominio.dao.ObtenerRutinaDao;

@Repository
public class ObtenerRutinaExcelDao implements ObtenerRutinaDao {

	public static final String VERB_FILE = "/src/main/resources/present/verb/present_verb.xlsx";
	public static final int VERB_SHEET = 1;

	@Override
	public List<String> listaVerbos(int cantidad, int hojaTemaExcel) {
		return ejecutar(cantidad, hojaTemaExcel);
	}

	public List<String> ejecutar(int id, int hojaTemaExcel) {

		OPCPackage file = obtenerArchivo();
		XSSFWorkbook excel = creacionWorkBook(file);
		XSSFSheet sheet = obtenerHojaExcel(excel, hojaTemaExcel);

		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<String> allVerb = new ArrayList<>();

		int verbos = 0;

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			allVerb.add(row.getCell(0).toString());
			verbos++;
			
			if (id == verbos)
				break;

		}

		return allVerb;

	}

	private XSSFSheet obtenerHojaExcel(XSSFWorkbook excel, int hojaTemaExcel) {
		//return excel.getSheetAt(VERB_SHEET);
		return excel.getSheetAt(hojaTemaExcel);
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
