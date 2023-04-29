package GUI;

import aplicacion.*;
import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{
    private JPanel MainPanel;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton HOSTELERIAButton;
    private JButton ENTRADASButton;
    private JButton VOLVERButton;
    private JButton SALIRButton;
public UserPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos){
    //ponemos el titulo de la pestaña
    setTitle("Usuario");
    //Mostramos el panel del .form
    setContentPane(MainPanel);
    //Ponemos el tamaño de la ventana
    setMinimumSize(new Dimension(700,500));
    //Centramos la pestaña
    setLocationRelativeTo(parent);
    //Esto hace que se cierre al darle a la X
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);

    ATRACCIONESButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    });
    ESPECTACULOSButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    });
    HOSTELERIAButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    });
    ENTRADASButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    });
    VOLVERButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //LoginGUI menuLogin=new LoginGUI(null, aplicacion.FachadaAplicacion, fachadaBaseDatos);
            dispose();
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
