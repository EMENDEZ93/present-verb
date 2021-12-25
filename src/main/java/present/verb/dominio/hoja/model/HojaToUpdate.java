package present.verb.dominio.hoja.model;

import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.excel.modelo.Excel;
import present.verb.dominio.excel.modelo.ExcelToUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@Entity
@Table(name="hoja_to_update")
@Setter
@Getter
public class HojaToUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int indiceExcel;
    private int filas;

    @ManyToOne
    @JoinColumn
    private ExcelToUpdate excelToUpdate;

    public HojaToUpdate() {}

}
