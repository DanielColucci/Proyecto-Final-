import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tienda<T extends ProductoBase> implements Iterable<T> {
    private List<T> productos;

    public Tienda() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (T producto : productos) {
            producto.mostrarInformacion();
        }
    }

    public void ordenarProductosPorNombre() {
        Collections.sort(productos, ProductoBase.comparadorPorNombre);
    }

    // Implementación de iterador
    @Override
    public Iterator<T> iterator() {
        return productos.iterator();
    }

    public List<T> getProductos() {
        return new ArrayList<>(productos);
    }
}



