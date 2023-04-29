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
    private JButton ACTUALIZARButton;
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

        //Boton para actualizar
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = DNITextField.getText();
                String name = NameTextField.getText();
                String type = TypeTextField.getText();
                String Attraction = AttractionTextField.getText();
                String Show = ShowTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////

                int Atraccion = 0, Espectaculo = 0;
                try {
                    // Convierte el String a un float
                    Atraccion = Integer.parseInt(Attraction);
                    Espectaculo = Integer.parseInt(Show);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                switch ((type.toLowerCase())){
                    //Caso de administracion
                    case "administracion":
                        //Hago un try y catch para manejar la excepcion
                        try {
                            fachadaBaseDatos.actualizarTrabajadorAdministracion(dni, name, Atraccion, Espectaculo);
                            dispose();
                            UpdateEmployee menuContratar = new UpdateEmployee(null, fachadaBaseDatos);

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de mantenimiento
                    case "mantenimiento":
                        try {
                            fachadaBaseDatos.actualizarTrabajadorMantenimiento(dni, name, Atraccion);
                            dispose();
                            UpdateEmployee menuContratar = new UpdateEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de espectaculos
                    case "espectaculos":
                        try {
                            fachadaBaseDatos.actualizarTrabajadoresEspectaculo(dni, name, Espectaculo);
                            dispose();
                            UpdateEmployee menuContratar = new UpdateEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    default:
                        System.out.println("Trabajo incorrecto");
                }
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
