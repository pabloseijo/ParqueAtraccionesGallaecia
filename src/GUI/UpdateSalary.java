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

public class UpdateSalary extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JTextField DNITextField;
    private JTextField SalaryTextField;
    private JButton SALIRButton;
    private JButton VOLVERButton;
    private JButton ACTUALIZARButton;
    private JPanel MainPanel;
    private JTextField TypeTextField;
    private JTable table1;
    private JScrollPane scrollPane1;

    public UpdateSalary(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
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

        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = DNITextField.getText();
                String Job = TypeTextField.getText();
                String salary = SalaryTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////

                //Casteamos los float
                float Salary = 0.0f;
                try {
                    // Convierte el String a un float
                    Salary = Float.parseFloat(salary);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException SalaryException) {
                    System.out.println("FATAL ERROR: Float could not been converted");
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                switch ((Job.toLowerCase())){
                    //Caso de administracion
                    case "administracion":
                        //Hago un try y catch para manejar la excepcion
                        try {
                            //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                            fachadaBaseDatos.actualizarSalarioAdministracion(dni, Salary);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            UpdateSalary actualizarSalario = new UpdateSalary(null, fachadaBaseDatos);

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de mantenimiento
                    case "mantenimiento":
                        try {
                            fachadaBaseDatos.actualizarSalarioMantenimiento(dni, Salary);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            UpdateSalary actualizarSalario = new UpdateSalary(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de espectaculos
                    case "espectaculos":
                        try {
                            fachadaBaseDatos.actualizarSalarioEspectaculo(dni, Salary);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            UpdateSalary actualizarSalario = new UpdateSalary(null, fachadaBaseDatos);
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
        model.addColumn("Salario");

        ArrayList<Trabajador> listaEmpleados = null;
        try {
            listaEmpleados = FachadaBaseDatos.getTrabajadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listaEmpleados.size(); i++) {
            model.addRow(new Object[]{listaEmpleados.get(i).getDni(), listaEmpleados.get(i).getNombre(), listaEmpleados.get(i).getClass().getSimpleName(), listaEmpleados.get(i).getSalario()});
        }
        // Crear el JTable y asignarle el modelo
        table1 = new JTable(model);

        // Crear el JScrollPane y asignarle el JTable
        scrollPane1 = new JScrollPane(table1);
    }
}
