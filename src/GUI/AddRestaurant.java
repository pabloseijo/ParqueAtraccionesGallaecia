package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRestaurant extends JDialog{
    private JTextField NameTextField;
    private JTextField CapacityTextField;
    private JTextField UbicationTextField;
    private JTextField ApertureTimeTextField;
    private JTextField ClosingTimeTextField;
    private JTextField RecaudationTextFIeld;
    private JButton ANHADIRButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;


    public AddRestaurant(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
        super(parent);
        //ponemos el titulo de la pestaña
        setTitle("Añadir Espectaculo");
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
                RestaurantsPage menuResaturante = new RestaurantsPage(null, fachadaBaseDatos);
                dispose();
            }
        });

        //Boton de buscar
        ANHADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String name = NameTextField.getText();
                String capacity = CapacityTextField.getText();
                String ubication = UbicationTextField.getText();
                String apertureTime = ApertureTimeTextField.getText();
                String closingTime = ClosingTimeTextField.getText();
                String recaudation = RecaudationTextFIeld.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

                Time StartTime, EndTime;
                try {
                    // Convierte el String a un float
                    Date date = dateFormat.parse(apertureTime);
                    StartTime = new Time(date.getTime());

                    // Convierte el String a un float
                    Date date2 = dateFormat.parse(closingTime);
                    EndTime = new Time(date.getTime());
                    // floatValue contiene el número convertido
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }


                //Casteamos los float
                float Recaudation = 0.0f;
                try {
                    // Convierte el String a un float
                    Recaudation = Float.parseFloat(recaudation);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException SalaryException) {
                    System.out.println("FATAL ERROR: Float could not been converted");
                }

                int Capacity = 0;
                try {
                    // Convierte el String a un float
                    Capacity = Integer.parseInt(capacity);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Hago un try y catch para manejar la excepcion
                try {
                    //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                    fachadaBaseDatos.anhadirRestaurante(name, Capacity, ubication, StartTime, EndTime, Recaudation);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddRestaurant menuRestaurante = new AddRestaurant(null, fachadaBaseDatos);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }
}
