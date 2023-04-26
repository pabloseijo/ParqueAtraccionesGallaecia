package GUI;

import aplicacion.Trabajador;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FireEmployee extends JDialog {
    private JTextField DNITextField;
    private JTextField EmployeeTypeTextField;
    private JTable table1;
    private JPanel MainPanel;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton DESPEDIRButton;

    public FireEmployee(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {

        super(parent);
        setTitle("HireEmployee");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(900, 300));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

        DESPEDIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String dni = DNITextField.getText();
                //ANHADIR ATRACCION Y ESPECTACULO
                //El tipo de empleado (matenimiento...)
                String Job = EmployeeTypeTextField.getText();

                //Para a asginar a un trabajador un espectaculo o una atraccion podemos hacerlo en update
                // Con este switch ponemos los casos posibles para despedir un trabajador
                switch ((Job.toLowerCase())){
                    //Caso de administracion
                    case "administracion":
                        //Hago un try y catch para manejar la excepcion
                        try {
                            fachadaBaseDatos.despedirTrabajadorAdministracion(dni);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            FireEmployee ByeByeEmployeeMenu = new FireEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de mantenimiento
                    case "mantenimiento":
                        try {
                            fachadaBaseDatos.despedirTrabajadorMantenimiento(dni);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            FireEmployee ByeByeEmployeeMenu = new FireEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de espectaculos
                    case "espectaculos":
                        try {
                            fachadaBaseDatos.despedirTrabajadorEspectaculo(dni);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            FireEmployee ByeByeEmployeeMenu = new FireEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    default:
                        System.out.println("El trabajador no existe");
                }
            }
        });
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
