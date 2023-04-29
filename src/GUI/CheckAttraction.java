package GUI;

import aplicacion.Atraccion;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckAttraction extends JDialog{
    private JTable table1;
    private JPanel MainPanel;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private FachadaBaseDatos fachadaBaseDatos;
    private JScrollPane scrollPane1;

    public CheckAttraction(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        createUIComponents();

        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700, 500));
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
                EmployeePage menuEmployee = new EmployeePage(null, fachadaBaseDatos);
            }
        });
    }

    private void createUIComponents() {
        // Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Altura Minima");
        model.addColumn("Ubicacion");

        ArrayList<Atraccion> listaAtracciones = null;
        try {
            listaAtracciones = FachadaBaseDatos.consultarAtracciones();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaAtracciones.size(); i++) {
            model.addRow(new Object[]{listaAtracciones.get(i).getNombre(), listaAtracciones.get(i).getAlturaMin(), listaAtracciones.get(i).getUbicacion()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        scrollPane1 = new JScrollPane(table1);
    }
}
