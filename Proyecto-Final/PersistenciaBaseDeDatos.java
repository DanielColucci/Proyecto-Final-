import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaBaseDeDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/tienda1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void guardarProductoEnBD(ProductoBase producto) {
        String query = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setDouble(2, producto.getPrecio());
            preparedStatement.executeUpdate();
            System.out.println("Producto guardado en la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al guardar en la base de datos: " + e.getMessage());
        }
    }

    public static List<ProductoBase> obtenerProductosDesdeBD() {
        List<ProductoBase> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                ProductoBase producto = new Producto(nombre, precio);
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos desde la base de datos: " + e.getMessage());
        }

        return productos;
    }
}
