package Actualizado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaArchivo<T> implements PersistenciaDatos<T> {
    private final Gson gson = new Gson();

    @Override
    public void guardarCSV(List<T> datos, String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (T dato : datos) {
                writer.write(dato.toString());
                writer.newLine();
            }
        }
    }

    @Override
    public List<T> cargarCSV(String archivo) throws IOException {
        List<T> datos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // implementar lógica de parseo para convertir la línea en objetos
            }
        }
        return datos;
    }

    @Override
    public void guardarJSON(List<T> datos, String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            gson.toJson(datos, writer);
        }
    }

    @Override
    public List<T> cargarJSON(String archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            return gson.fromJson(reader, new TypeToken<List<T>>() {}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
