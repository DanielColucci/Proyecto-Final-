import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaOnlineGUI extends JFrame implements ActionListener {
    private JTextField nombreProductoField, precioProductoField, marcaField;
    private JTextArea resultadoArea;

    public TiendaOnlineGUI() {
        // Configuración de la ventana principal
        setTitle("Tienda Online");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Componentes de la interfaz
        JLabel nombreProductoLabel = new JLabel("Nombre del Producto:");
        nombreProductoField = new JTextField();

        JLabel precioProductoLabel = new JLabel("Precio del Producto:");
        precioProductoField = new JTextField();

        JLabel marcaLabel = new JLabel("Marca:");
        marcaField = new JTextField();

        JButton agregarProductoButton = new JButton("Agregar Producto");
        agregarProductoButton.addActionListener(this);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        // Agregar componentes a la ventana
        add(nombreProductoLabel);
        add(nombreProductoField);
        add(precioProductoLabel);
        add(precioProductoField);
        add(marcaLabel);
        add(marcaField);
        add(new JLabel()); 
        add(agregarProductoButton);
        add(new JLabel());
        add(new JLabel()); 
        add(resultadoArea);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar Producto")) {
            agregarProducto();
        }
    }

    private void agregarProducto() {
        String nombre = nombreProductoField.getText();
        String precioStr = precioProductoField.getText();
        String marca = marcaField.getText();

        try {
            double precio = Double.parseDouble(precioStr);

            // Crear un ProductoElectronico y mostrar la información en la interfaz
            ProductoElectronico producto = new ProductoElectronico(nombre, precio, marca);
            resultadoArea.append("\nProducto Agregado:\n");
            resultadoArea.append("Nombre: " + producto.getNombre() + "\n");
            resultadoArea.append("Precio: $" + producto.getPrecio() + "\n");
            resultadoArea.append("Marca: " + producto.getMarca() + "\n");

            // Guardar el producto en la base de datos
            PersistenciaBaseDeDatos.guardarProductoEnBD(producto);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TiendaOnlineGUI());
    }
}
