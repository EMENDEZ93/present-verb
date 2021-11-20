package present.verb.dominio.usuario.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import present.verb.dominio.excel.modelo.Excel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Setter
@Getter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idFirebase;
    private String correo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Excel> excels;

    public Usuario(String correo, String idFirebase) {
        setId(id);
        setCorreo(correo);
        setIdFirebase(idFirebase);
    }

}
