package Actualizado;
import java.io.*;
import java.util.List;

public interface PersistenciaDatos<T> {
    void guardarCSV(List<T> datos, String archivo) throws IOException;
    List<T> cargarCSV(String archivo) throws IOException;
    void guardarJSON(List<T> datos, String archivo) throws IOException;
    List<T> cargarJSON(String archivo) throws IOException;
}
