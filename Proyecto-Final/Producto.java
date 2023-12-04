import java.util.Comparator;
public class Producto extends ProductoBase {
    public Producto(String nombre, double precio) {
        super(nombre, precio);
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
    }
    public static Comparator<ProductoBase> comparadorPorNombre = Comparator.comparing(ProductoBase::getNombre);
    public static Comparator<ProductoBase> getComparadorPorNombre() {
        return comparadorPorNombre;
    }
    public static void setComparadorPorNombre(Comparator<ProductoBase> comparadorPorNombre) {
        Producto.comparadorPorNombre = comparadorPorNombre;
    }
}
