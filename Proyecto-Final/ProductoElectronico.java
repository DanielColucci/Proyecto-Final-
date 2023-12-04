public class ProductoElectronico extends ProductoBase {
    private String marca;

    public ProductoElectronico(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }
    

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Marca: " + marca);
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }
}