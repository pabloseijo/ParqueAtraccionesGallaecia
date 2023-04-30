package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aplicacion.*;

public class UserPage extends JFrame{
    private JPanel MainPanel;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton HOSTELERIAButton;
    private JButton VERENTRADASButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
    private JButton COMPRARENTRADASButton;

    public UserPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos, String usuario){
    //ponemos el titulo de la pestaña
    setTitle("Usuario");
    //Mostramos el panel del .form
    setContentPane(MainPanel);
    //Ponemos el tamaño de la ventana
    setMinimumSize(new Dimension(1000,500));
    //Centramos la pestaña
    setLocationRelativeTo(parent);
    //Esto hace que se cierre al darle a la X
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);

    ATRACCIONESButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CheckAttraction checkAttraction = new CheckAttraction( null, fachadaBaseDatos, usuario);
            dispose();
        }
    });
    ESPECTACULOSButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            CheckShows checkShows = new CheckShows(null,fachadaBaseDatos,usuario);
            dispose();
        }
    });
    HOSTELERIAButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            BookRestaurant bookRestaurant = new BookRestaurant(null, fachadaBaseDatos, usuario);
            dispose();
        }
    });
    COMPRARENTRADASButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
            AddTicket menuAddTicket=new AddTicket(null, fachadaBaseDatos, usuario);
        }
    });

    VERENTRADASButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            SeeTicketsPage menuSeeTicket=new SeeTicketsPage(null, fachadaBaseDatos, usuario);
            dispose();
        }
    });
    VOLVERButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
            LoginGUI menuLogin=new LoginGUI(null, new FachadaAplicacion(), fachadaBaseDatos);
        }
    });
    SALIRButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    });
    }
}
