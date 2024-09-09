package present.verb.common.infrastructura;

import present.verb.common.utils.BuilderUtils;
import present.verb.dominio.hoja.model.Hoja;

import java.util.Optional;

import static java.util.Optional.of;

public class InfraestructuraBuilder extends BuilderUtils {

    public static Optional<Hoja> crearHoja() {
        return of(readJsonFromFile(
                "hoja/hoja_1.json",
                Hoja.class
        ));
    }

}
