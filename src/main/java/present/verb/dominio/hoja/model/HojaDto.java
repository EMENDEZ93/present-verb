package present.verb.dominio.hoja.model;


import java.time.LocalDate;

public interface HojaDto {

    public int getId();
    public String getNombre();
    public int getUltimoIndiceAprendido();
    public int getRepeticionesAltaComoAprendido();
    public int getNumeroVerbosPorAprenderDiario();
    public LocalDate getUltimaFechaAprendio();
    public LocalDate getUltimaFechaRutina();
    public boolean isEsPreguntaRespuesta();
    public int getIndiceExcel();
    public int getFilas();
    public Boolean getPorRutina();

}
