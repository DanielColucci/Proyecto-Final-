public class Main {
    public static void main(String[] args) {
        Tienda<ProductoBase> tienda = new Tienda<>();

        Producto producto1 = new Producto("A", 50);
        Producto producto2 = new Producto("C", 30);
        ProductoElectronico electronico1 = new ProductoElectronico("B", 100, "Samsung");

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(electronico1);

        System.out.println("Productos sin ordenar:");
        tienda.mostrarProductos();

        // Ordenar por nombre
        tienda.ordenarProductosPorNombre();

        System.out.println("\nProductos ordenados por nombre:");
        tienda.mostrarProductos();

        // Usar iterador
        System.out.println("\nRecorriendo la tienda con iterador:");
        for (ProductoBase producto : tienda) {
            producto.mostrarInformacion();
        }
    }
}
