package GUI;

import aplicacion.Atraccion;
import aplicacion.Espectaculo;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CountVisitorsAttraction extends JDialog{
    private JTextField textField1;
    private JTable table1;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton OBTENERButton;
    private JPanel MainPanel;

    private FachadaBaseDatos fachadaBaseDatos;

    public CountVisitorsAttraction(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        createUIComponents();

        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        //Boton de salir (Cierra la ventana)
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //Boton de volver a la pestaña anterior
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AttractionPage AtraccionPage = new AttractionPage(null, fachadaBaseDatos);
            }
        });


        OBTENERButton.addActionListener(new ActionListener() {

            public void imprimirSuma(int id) {

                try {
                    float suma = fachadaBaseDatos.contarVisitantes(id);
                    JOptionPane.showMessageDialog(null, "El numero de espectadores de la atraccion seleccionada es " + suma);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            @Override
            public void actionPerformed(ActionEvent e) {

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                String espectaculo = textField1.getText();

                int id = 0;
                try {
                    // Convierte el String a un float
                    id = Integer.parseInt(espectaculo);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                this.imprimirSuma(id);
            }
        });
    }

    private void createUIComponents() {
        /// Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numero de Registro");
        model.addColumn("Nombre");
        model.addColumn("Aforo");
        model.addColumn("Ubicacion");

        java.util.List<Atraccion> listaAtracciones = null;
        try {
            listaAtracciones = FachadaBaseDatos.consultarAtracciones();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaAtracciones.size(); i++) {
            model.addRow(new Object[]{listaAtracciones.get(i).getNumeroRegistro(), listaAtracciones.get(i).getNombre(),
                    listaAtracciones.get(i).getAforo(), listaAtracciones.get(i).getUbicacion()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        JScrollPane scrollPane1 = new JScrollPane(table1);
    }
}
