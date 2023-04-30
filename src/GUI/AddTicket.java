package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AddTicket extends JDialog{
    private JPanel MainPanel;
    private JTextField dnitextField1;
    private JTextField nombretextField1;
    private JTextField fechanacimientotextField1;
    private JButton SALIRButton;
    private JButton VOLVERButton;
    private JButton ANADIRButton;
    private String user;
    public AddTicket(JFrame parent, FachadaBaseDatos fachadaBaseDatos, String usuario){
        super(parent);
        this.user=usuario;
        //ponemos el titulo de la pestaña
        setTitle("Añadir Entradas");
        //Mostramos el panel del .form
        setContentPane(MainPanel);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(1000,500));
        setModal(true);
        //Centramos la pestaña
        setLocationRelativeTo(parent);
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                UserPage menuUsuario = new UserPage(null, fachadaBaseDatos, usuario);
            }
        });
        ANADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Lanza una pestaña que con el nombre y el dni hace una consulta en sql y añade un empleado a la base
                String dni = dnitextField1.getText();
                String name = nombretextField1.getText();
                String birthDate = fechanacimientotextField1.getText();
                String userName = user;

                /////////////////////////* TRANSFORMAMOS LOS STRING A LOS TIPOS NECESARIOS *////////////////////////////
                // Crea un objeto SimpleDateFormat con el formato deseado
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                //Casteamos las fechas
                java.sql.Date Birthday = null;
                try {
                    // Convierte el String a un objeto java.sql.Date
                    Birthday = java.sql.Date.valueOf(birthDate);
                    // sqlDate contiene la fecha convertida
                } catch (IllegalArgumentException DateException) {
                    System.out.println("FATAL ERROR: Date could not been converted");
                }

                try {
                    //Le paso los parametros a para añadir el trabajador, pero espectaculo y atraccion se lo paso a 0 porque se actualizara mas tarde
                    fachadaBaseDatos.anhadirEntrada(dni, name, Birthday, userName);
                    //meter aqui el lazamiento de la pagina siguiente
                    dispose();
                    AddTicket menuAddTicket = new AddTicket(null, fachadaBaseDatos, usuario);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        setVisible(true);
    }
}
