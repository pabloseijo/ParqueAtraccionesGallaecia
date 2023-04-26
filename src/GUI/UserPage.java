package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{

    private FachadaBaseDatos fachadaBaseDatos;
    private JButton SALIRButton;
    private JLabel IconoUsuario;
    private JLabel Pulpo;
    private JLabel NombreUsuario;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton HOSTELERIAButton;
    private JButton ENTRADASButton;

    private JPanel Jpanel1;
    private JPanel MainPanel;
    private JButton COMPRARENTRADASButton;
    private JButton VOLVERButton;

    public UserPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {
        ////////////////////////////////////////////////
        // ARREGLAR NON FUNCIONA
        ////////////////////////////////////////////
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
        
        ATRACCIONESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ESPECTACULOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HOSTELERIAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ENTRADASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        COMPRARENTRADASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
