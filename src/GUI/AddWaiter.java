package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AddWaiter extends JDialog {
    private JTextField DNITextField;
    private JTextField NameTextField;
    private JTextField DirectionTextField;
    private JTextField SalaryTextField;
    private JTextField TlfTextField;
    private JTextField HireDateTextField;
    private JTextField BirthDateTextField;
    private JTextField EducationTextField;
    private JTextField RestaurantTextField;
    private JButton ANHADIRButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;


    public AddWaiter(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
        super(parent);
        //ponemos el titulo de la pestaña
        setTitle("HireWaiter");
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
                dispose();
                RestaurantsPage menuRestaurante = new RestaurantsPage(null, fachadaBaseDatos);
            }
        });

        //Boton de buscar
        ANHADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String dni = DNITextField.getText();
                String name = NameTextField.getText();
                String direction = DirectionTextField.getText();
                String salary = SalaryTextField.getText();
                String telephoneNumber = TlfTextField.getText();
                String hireDate = HireDateTextField.getText();
                String birthDate = BirthDateTextField.getText();
                String education = EducationTextField.getText();
                String restaurant = RestaurantTextField.getText();

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

                int Phone = 0, Restaurant = 0;
                try {
                    // Convierte el String a un float
                    Phone = Integer.parseInt(telephoneNumber);
                    Restaurant = Integer.parseInt(restaurant);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////
                //Añadimos el camarero al restaurante
                try {
                    fachadaBaseDatos.anhadirHostelero(dni, name, direction, Salary, Phone, HireDate, Birthday, education, Restaurant);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddWaiter menuContratar = new AddWaiter(null, fachadaBaseDatos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
