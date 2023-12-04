import java.util.Comparator;

public class ProductoBase implements Comparable<ProductoBase> {
    protected String nombre;
    protected double precio;

    public ProductoBase(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Precio: $" + precio);
    }

    public double calcularPrecioConImpuestos(double impuestoPorcentaje) throws IllegalArgumentException {
        if (impuestoPorcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje de impuestos no puede ser negativo");
        }
        try {
            double impuesto = precio * impuestoPorcentaje / 100;
            return precio + impuesto;
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético al calcular el precio con impuestos.");
            return precio;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(ProductoBase otroProducto) {
        return this.nombre.compareTo(otroProducto.nombre);
    }

    public static Comparator<ProductoBase> comparadorPorNombre = Comparator.comparing(ProductoBase::getNombre);
}
