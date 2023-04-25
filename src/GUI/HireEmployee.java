package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


import baseDatos.*;

public class HireEmployee extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JLabel IconoAdmin;
    private JPanel MainPanel;
    private JButton ANHADIRButton, VOLVERButton, SALIRButton;

    private JTextField DNITextField, NameTextField, JobTextField; //JobTextField es basicamente el tipo de empleado que es, si de mantenimiento etc,
    private JTextField HomeDirectionTextField, SalaryTextField, TlfTextField, HireDateTextField, BirthdayTextField, EducationTextField;
    private JLabel pulpoMiguel;

    public HireEmployee(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
        super(parent);
        //ponemos el titulo de la pestaña
        setTitle("HireEmployee");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(1000,500));
        setModal(true);
        //Centramos la pestaña
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
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
                EmployeePage menuUsuario = new EmployeePage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Boton de buscar
        ANHADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String dni = DNITextField.getText();
                String name = NameTextField.getText();
                String direction = HomeDirectionTextField.getText();
                String salary = SalaryTextField.getText();
                String telephoneNumber = TlfTextField.getText();
                String hireDate = HireDateTextField.getText();
                String birthDate = BirthdayTextField.getText();
                String education = EducationTextField.getText();
                //ANHADIR ATRACCION Y ESPECTACULO
                //El tipo de empleado (matenimiento...)
                String Job = JobTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                //Casteamos las fechas
                java.sql.Date HireDate = null, Birthday = null;
                try {
                    // Convierte el String a un objeto java.sql.Date
                    HireDate = java.sql.Date.valueOf(hireDate);
                    Birthday = java.sql.Date.valueOf(birthDate);
                    // sqlDate contiene la fecha convertida
                } catch (IllegalArgumentException DateException) {
                    System.out.println("FATAL ERROR: Date could not been converted");
                }

                //Casteamos los float
                float Salary = 0.0f;
                try {
                    // Convierte el String a un float
                    Salary = Float.parseFloat(salary);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException SalaryException) {
                    System.out.println("FATAL ERROR: Float could not been converted");
                }

                int Phone = 0;
                try {
                    // Convierte el String a un float
                    Phone = Integer.parseInt(telephoneNumber);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Para a asginar a un trabajador un espectaculo o una atraccion podemos hacerlo en update
                // Con este switch ponemos los casos posibles para añadir un trabajador
                switch ((Job.toLowerCase())){
                    //Caso de administracion
                    case "administracion":
                        //Hago un try y catch para manejar la excepcion
                        try {
                            //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                            fachadaBaseDatos.anhadirTrabajadorAdministracion(dni, name, direction, Salary, Phone, HireDate, Birthday, education,1,1);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            HireEmployee menuContratar = new HireEmployee(null, fachadaBaseDatos);

                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de mantenimiento
                    case "mantenimiento":
                        try {
                            fachadaBaseDatos.anhadirTrabajadorMantenimiento(dni, name, direction, Salary, Phone, HireDate, Birthday, education,1);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            HireEmployee menuContratar = new HireEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    //Caso de espectaculos
                    case "espectaculos":
                        try {
                            fachadaBaseDatos.anhadirTrabajadorEspectaculo(dni, name, direction, Salary, Phone, HireDate, Birthday, education,1);
                            //meter aqui el lazamiento de la pagina siguiente
                            dispose();
                            HireEmployee menuContratar = new HireEmployee(null, fachadaBaseDatos);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;

                    default:
                        System.out.println("Trabajo incorrecto");
                }
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
