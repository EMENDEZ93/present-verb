package present.verb.dominio.excel.modelo;

import lombok.Getter;
import lombok.Setter;
import present.verb.dominio.hoja.model.Hoja;
import present.verb.dominio.usuario.modelo.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "excel")
@Setter
@Getter
public class Excel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String archivo;

    @OneToMany(mappedBy = "excel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hoja> hojas;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

}
