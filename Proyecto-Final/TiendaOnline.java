public class TiendaOnline {
    public static void main(String[] args) {
        Tienda<ProductoBase> tienda = new Tienda<>();

        Producto producto1 = new Producto("A", 50);
        Producto producto2 = new Producto("C", 30);

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);

        PersistenciaTexto.guardarProductosEnTexto(tienda.getProductos(), "productos.txt");
    }
}

