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

public class AddShow extends JDialog{
    private JTextField NameTextField;
    private JTextField SessionTextField;
    private JTextField StartTimeTextField;
    private JTextField EndTimeTextField;
    private JTextField ThemeTexteField;
    private JTextField DescriptionTextField;
    private JTextField UbicationTextField;
    private JButton ANHADIRButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JPanel MainPanel;

    public AddShow(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
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
                dispose();
                ShowsPage menuEspectaculo = new ShowsPage(null, fachadaBaseDatos);
            }
        });

        //Boton de buscar
        ANHADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String name = NameTextField.getText();
                String session = SessionTextField.getText();
                String startTime = StartTimeTextField.getText();
                String endTime = EndTimeTextField.getText();
                String theme = ThemeTexteField.getText();
                String ubication = UbicationTextField.getText();
                String description = DescriptionTextField.getText();

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

                Time StartTime, EndTime;
                try {
                    // Convierte el String a un float
                    Date date = dateFormat.parse(startTime);
                    StartTime = new Time(date.getTime());

                    // Convierte el String a un float
                    Date date2 = dateFormat.parse(endTime);
                    EndTime = new Time(date.getTime());
                    // floatValue contiene el número convertido
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////

                //Hago un try y catch para manejar la excepcion
                try {
                    //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                    fachadaBaseDatos.anhadirEspectaculo(name, session, StartTime, EndTime, theme, description, ubication);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddShow menuEspectaculo = new AddShow(null, fachadaBaseDatos);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Ponemos que se visualice la ventana
        setVisible(true);
    }
}
