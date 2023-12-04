public class Pedido extends ProductoBase implements Enviable {
    public Pedido(ProductoBase producto) {
        super(producto.nombre, producto.precio);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Pedido del producto: " + nombre);
        System.out.println("Precio del pedido: $" + precio);
    }

    @Override
    public void procesarEnvio() {
        try {
            System.out.println("Procesando envío para el producto: " + nombre);
            if (precio < 0) {
                throw new Exception("Precio inválido en el producto");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el envío: " + e.getMessage());
        }
    }
    
}