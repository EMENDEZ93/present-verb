package present.verb.dominio.excel.modelo;

import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.hoja.model.HojaToUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "excel_to_update")
@Setter
@Getter
public class ExcelToUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String archivo;

    @OneToMany(mappedBy = "excelToUpdate", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HojaToUpdate> hojas;

}
