import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaTexto {

    public static void guardarProductosEnTexto(List<ProductoBase> productos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (ProductoBase producto : productos) {
                writer.write(producto.toString());  
                writer.newLine();
            }
            System.out.println("Información de productos guardada en el archivo de texto: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo de texto: " + e.getMessage());
        }
    }
}
