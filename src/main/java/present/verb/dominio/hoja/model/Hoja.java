package present.verb.dominio.hoja.model;

import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.excel.modelo.Excel;

import javax.persistence.*;
import java.time.*;
import java.util.Date;

@Entity
@Table(name="hoja")
@Setter
@Getter
public class Hoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int ultimoIndiceAprendido;
    private int repeticionesAltaComoAprendido;
    private int numeroVerbosPorAprenderDiario;
    private LocalDate ultimaFechaAprendio;
    private LocalDate ultimaFechaRutina;
    private boolean esPreguntaRespuesta;
    private int indiceExcel;
    private int filas;
    private boolean porRutina;
    private String borrar;

    @ManyToOne
    @JoinColumn
    private Excel excel;

    public Hoja() {}

    public Hoja(
            String nombre,
            int ultimoIndiceAprendido,
            int repeticionesAltaComoAprendido,
            int numeroVerbosPorAprenderDiario,
            Date ultimaFechaAprendio,
            Date ultimaFechaRutina,
            boolean esPreguntaRespuesta,
            int indiceExcel,
            int filas
    ) {
        setNombre(nombre);
        setUltimoIndiceAprendido(ultimoIndiceAprendido);
        setRepeticionesAltaComoAprendido(repeticionesAltaComoAprendido);
        setNumeroVerbosPorAprenderDiario(numeroVerbosPorAprenderDiario);
        setUltimaFechaAprendio(java.sql.Date.valueOf(ultimaFechaAprendio.toString()).toLocalDate());
        setUltimaFechaRutina(java.sql.Date.valueOf(ultimaFechaRutina.toString()).toLocalDate());
        setEsPreguntaRespuesta(esPreguntaRespuesta);
        setIndiceExcel(indiceExcel);
        setFilas(filas);
    }

    @PrePersist
    public void prePersist() {
        ultimoIndiceAprendido = 0;
        repeticionesAltaComoAprendido = 3;
        numeroVerbosPorAprenderDiario = 5;
        ultimaFechaAprendio = LocalDate.of(2020, Month.JANUARY, 1);
        ultimaFechaRutina = LocalDate.of(2020, Month.JANUARY, 1);
    }

    public boolean getRealizadoAprenderHoy() {
        LocalDate ultimaFechaAprendio = getUltimaFechaAprendio();
        return ultimaFechaAprendio.isAfter(LocalDate.now()) || ultimaFechaAprendio.isEqual(LocalDate.now());
    }

    public boolean getRealizadoRutinasHoy() {
        LocalDate ultimaFechaAprendio = getUltimaFechaRutina();
        return ultimaFechaAprendio.isAfter(LocalDate.now()) || ultimaFechaAprendio.isEqual(LocalDate.now());
    }

}
