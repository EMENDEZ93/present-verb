package present.verb.dominio.espacios.trabajo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class ObtenerEspacioTrabajoTest {


    private List<String> ejemplos;


    public void setUp() {

        ejemplos = new ArrayList<>();
        ejemplos.add("ejemplo1");
        ejemplos.add("ejemplo2");
        ejemplos.add("ejemplo3");
        ejemplos.add("ejemplo4");
        ejemplos.add("ejemplo5");
        ejemplos.add("ejemplo6");
        ejemplos.add("ejemplo7");
        ejemplos.add("ejemplo8");
        ejemplos.add("ejemplo9");
        ejemplos.add("ejemplo10");
    }



    public void readTest() {
        List<Integer> indices = new ArrayList<>();
        List<Integer> iterados = new ArrayList<>();

        for (int i = 0; i < ejemplos.size(); i++) {

            if (iterados.size() < 2 ) {
                List<Integer> ultimosCinco = extractedUltimos5(iterados);
                indices.add(i);
                indices.addAll(ultimosCinco);
                iterados.add(i);
            } else if (iterados.size() <= 4 ) {
                List<Integer> ultimosCinco = extractedUltimos5(iterados);
                ultimosCinco.remove(0);
                ultimosCinco.add(i);
                indices.addAll(ultimosCinco);

                Collections.reverse(ultimosCinco);
                ultimosCinco.remove(0);
                ultimosCinco.add(0);
                indices.addAll(ultimosCinco);
                iterados.add(i);
            } else if (iterados.size() >= 5 ) {
                iterados.add(i);
                List<Integer> ultimosCinco = extractedUltimos5(iterados);
                indices.addAll(ultimosCinco);
                Collections.reverse(ultimosCinco);
                ultimosCinco.remove(0);
                indices.addAll(ultimosCinco);
            }
        }

        List<Integer> ultimosCinco = extractedUltimos5(indices);
        Collections.reverse(ultimosCinco);
        ultimosCinco.remove(0);
        indices.addAll(ultimosCinco);

        Collections.reverse(ultimosCinco);
        ultimosCinco.remove(0);
        indices.addAll(ultimosCinco);
    }

    private static List<Integer> extractedUltimos5(List<Integer> indicesStack) {
        Stack<Integer> stackTemporal = new Stack<>();
        stackTemporal.addAll(indicesStack);
        Collections.reverse(stackTemporal);
        int cantidad = Math.min(5, stackTemporal.size());
        List<Integer> resultado = stackTemporal.subList(0, cantidad);
        Collections.reverse(resultado);
        return resultado;
    }


}