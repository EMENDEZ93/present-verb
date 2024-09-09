package present.verb.common.utils;

import com.google.gson.Gson;
import present.verb.common.infrastructura.InfraestructuraBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

public class BuilderUtils {

    public static <T> T readJsonFromFile(String fileName, Class<T> clazz) {
        try {
            InputStream inputStream = InfraestructuraBuilder.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new IOException("Archivo no encontrado: " + fileName);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return new Gson().fromJson(stringBuilder.toString(), clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Supplier<RuntimeException> error() {
        return () -> new RuntimeException("No se pudo cargar el archivo de prueba");
    }

}
