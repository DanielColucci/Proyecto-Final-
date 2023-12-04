public class TiendaOnline {
    public static void main(String[] args) {

        ProductoElectronico laptop = new ProductoElectronico("Laptop", 1300.0, "Dell");
        ProductoElectronico celular = new ProductoElectronico("Moto G7 Plus", 2222, "Motorola");

        laptop.mostrarInformacion();
        laptop.calcularPrecioConImpuestos(12);
        
        celular.mostrarInformacion();
        celular.calcularPrecioConImpuestos(21);


        Pedido pedido = new Pedido(laptop);
        Pedido pedido2 = new Pedido(celular);

        pedido.procesarEnvio();
        pedido2.procesarEnvio();
    }
}
