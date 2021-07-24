package present.verb.infraestructura.health.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {

    @GetMapping("/health")
    public boolean ejecutar() {
        return true;
    }

}
