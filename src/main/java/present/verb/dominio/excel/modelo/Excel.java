package present.verb.dominio.excel.modelo;

import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.usuario.modelo.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Table(name = "excel")
@Setter
@Getter
public class Excel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String archivo;
    private Integer cantidadhojasPorRutina;
    private Integer ultimoIndiceRepaso;
    private LocalDate actualizacionIndiceRepaso;
    private Integer horaActualizacionIndiceRepaso;
    private Integer repeticionPorHoras;

    @OneToMany(mappedBy = "excel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hoja> hojas;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    @PrePersist
    public void prePersist() {
        setActualizacionIndiceRepaso(LocalDate.of(2020, Month.JANUARY, 1));
        setUltimoIndiceRepaso(0);
        setCantidadhojasPorRutina(5);
        setHoraActualizacionIndiceRepaso(0);
        setRepeticionPorHoras(12);
    }

    public boolean debeRealizarRepeticion(int horaActual) {
        if(isNull(getHoraActualizacionIndiceRepaso()) || isNull(getRepeticionPorHoras())) {
            return false;
        } else {
            int resultado = Math.abs(horaActual - getHoraActualizacionIndiceRepaso());
            return resultado >= getRepeticionPorHoras();
        }
    }

}
