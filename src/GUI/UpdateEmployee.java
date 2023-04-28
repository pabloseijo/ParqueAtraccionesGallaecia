package GUI;

import aplicacion.Trabajador;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateEmployee extends JDialog {
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField NameTextField;
    private JTextField DNITextField;
    private JTextField TypeTextField;
    private JTextField AttractionTextField;
    private JTextField ShowTextField;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;
    private JTable table1;
    private JScrollPane scrollPane1;


    public UpdateEmployee(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
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
                EmployeePage menuEmployee = new EmployeePage(null, fachadaBaseDatos);
            }
        });
    }

    private void createUIComponents() {
        // Crear un modelo de tabla con tres columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DNI");
        model.addColumn("Nombre");
        model.addColumn("Puesto");

        ArrayList<Trabajador> listaEmpleados = null;
        try {
            listaEmpleados = FachadaBaseDatos.getTrabajadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaEmpleados.size(); i++) {
            model.addRow(new Object[]{listaEmpleados.get(i).getDni(), listaEmpleados.get(i).getNombre(), listaEmpleados.get(i).getClass().getSimpleName()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        scrollPane1 = new JScrollPane(table1);
    }


}
