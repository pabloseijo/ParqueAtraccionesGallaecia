package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import baseDatos.*;

public class HireEmployee extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;
    private JLabel IconoAdmin;
    private JPanel MainPanel;
    private JButton BUSCARButton, VOLVERButton, SALIRButton;

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
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String dni = DNITextField.getText();
                String name = NameTextField.getText();
                String direction = HomeDirectionTextField.getText();
                String salary = SalaryTextField.getText(); //todo: castear el salario a float
                String telefoneNumber = TlfTextField.getText(); //todo: castear a integer
                String hireDate = HireDateTextField.getText(); //todo: castear a DATE
                String birthDate = BirthdayTextField.getText(); //todo: castear a DATE
                String education = EducationTextField.getText();
                //ANHADIR ATRACCION Y ESPECTACULO
                //El tipo de empleado (matenimiento...)
                String Job = JobTextField.getText();

                //Para a asginar a un trabajador un espectaculo o una atraccion podemos hacerlo en update
                if (Job.equals("Administracion")) {
                    // fachadaBaseDatos.anhadirTrabajadorAdministracion(dni, name, direction, salary, telefoneNumber, hireDate, birthDate, education);
                }
                else if (Job.equals("Mantenimiento")) {

                }
                else if (Job.equals("Espectaculos")) {

                }
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }
}
