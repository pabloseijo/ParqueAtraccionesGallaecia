package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class HireWaiter extends JDialog{
    private FachadaBaseDatos fachadaBaseDatos;

    private JTextField DNITextField;
    private JTextField NameTextField;
    private JTextField RestaurantTextField;
    private JTextField HomeDirectionTextField;
    private JTextField SalaryTextField;
    private JTextField TlfTextField;
    private JTextField HireDateTextField;
    private JTextField BirthdayTextField;
    private JTextField EducationTextField;
    private JButton ANHADIRButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;

    public HireWaiter(JFrame parent, FachadaBaseDatos fachadaBaseDatos){

        super(parent);
        this.fachadaBaseDatos = fachadaBaseDatos;
        //ponemos el titulo de la pestaña
        setTitle("Empleados");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Centramos la pestaña
        //IMPORTANTE!! La instancia parent se la paso para centrar la pestaña em el centro del ordenador, pero se le pasa null
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Ponemos la visibilidad de la pestaña
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
                String direction = HomeDirectionTextField.getText();
                String salary = SalaryTextField.getText();
                String telephoneNumber = TlfTextField.getText();
                String hireDate = HireDateTextField.getText();
                String birthDate = BirthdayTextField.getText();
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
                    HireWaiter menuContratar = new HireWaiter(null, fachadaBaseDatos);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }
}
