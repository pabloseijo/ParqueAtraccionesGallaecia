package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HireEmployee extends JDialog{
    private JLabel IconoAdmin;
    private JPanel MainPanel;
    private JButton BUSCARButton, VOLVERButton, SALIRButton;

    private JTextField DNITextField, NameTextField, JobTextField; //JobTextField es basicamente el tipo de empleado que es, si de mantenimiento etc,
    private JTextField HomeDirectionTextField, SalaryTextField, TlfTextField, HireDateTextField, BirthdayTextField, EducationTextField;
    private JLabel pulpoMiguel;

    public HireEmployee(JFrame parent){
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
                //meter aqui el lanzamiento de la pestaña anterior
            }
        });

        //Boton de buscar
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String DNI = DNITextField.getText();
                String Name = NameTextField.getText();
                String Direction = HomeDirectionTextField.getText();
                String Salary = SalaryTextField.getText(); //todo: castear el salario a float
                String TelefoneNumber = TlfTextField.getText(); //todo: castear a integer
                String HireDate = HireDateTextField.getText(); //todo: castear a DATE
                String BirthDate = BirthdayTextField.getText(); //todo: castear a DATE
                String Education = EducationTextField.getText();

                //El tipo de empleado (matenimiento...)
                String Job = JobTextField.getText();

                //Para a asginar a un trabajador un espectaculo o una atraccion podemos hacerlo en update
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }

    public static void main(String[] args){
        //Creamos la instancia
        HireEmployee myLogin = new HireEmployee(null);
        /*
        Usuario user = LoginGUI.user
        if(user != null){
            System.out.println("Bienvenido a Gallaecia: " + user.Nombre);
            //ponemos lo siguiente de pasar a la siguiente pestaña
        }
        else{
            System.out.println("Autentificacion cancelada");
        }*/
    }
}
