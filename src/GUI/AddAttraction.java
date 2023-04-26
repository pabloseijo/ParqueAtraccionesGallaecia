package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AddAttraction extends  JDialog{
    private JTextField NameTextField;
    private JTextField CapacityTextField;
    private JTextField MinHeightTextField;
    private JTextField MaintenanceCostTextField;
    private JTextField InReparationTextField;
    private JTextField UbicationTextField;
    private JTextField DescriptionTextField;
    private JButton ANHADIRButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;


    public AddAttraction(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
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
                dispose();
                AttractionPage menuAtraccion = new AttractionPage(null, fachadaBaseDatos);
            }
        });

        //Boton de buscar
        ANHADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String name = NameTextField.getText();
                String capacity = CapacityTextField.getText();
                String minHeight = MinHeightTextField.getText();
                String maintenance = MaintenanceCostTextField.getText();
                String reparation = InReparationTextField.getText();
                String ubication = UbicationTextField.getText();
                String description = DescriptionTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


                //Casteamos los float
                float Maintenance = 0.0f;
                try {
                    // Convierte el String a un float
                    Maintenance = Float.parseFloat(maintenance);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException SalaryException) {
                    System.out.println("FATAL ERROR: Float could not been converted");
                }

                int Capacity = 0, MinHeight = 0;
                try {
                    // Convierte el String a un float
                    Capacity = Integer.parseInt(capacity);
                    MinHeight = Integer.parseInt(minHeight);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                boolean Reparation = false;
                try {
                    // Convierte el String a un float
                    Reparation = Boolean.parseBoolean(reparation);
                    // floatValue contiene el número convertido
                } catch (NumberFormatException IntException) {
                    // El String no se pudo convertir
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Hago un try y catch para manejar la excepcion
                try {
                    //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                    fachadaBaseDatos.anhadirAtraccion(name, Capacity, MinHeight, Maintenance, Reparation, ubication, description);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddAttraction menuAñadirAtraccion = new AddAttraction(null, fachadaBaseDatos);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }
}
