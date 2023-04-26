package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{

    private JButton SALIRButton;
    private JLabel IconoUsuario;
    private JLabel Pulpo;
    private JLabel NombreUsuario;
    private JButton ATRACCIONESButton;
    private JLabel IconoEntradas;
    private JButton ESPECTÁCULOSButton;
    private JButton HOSTELERÍAButton;
    private JButton ENTRADASButton;
    private JPanel Jpanel1;
    private JPanel MainPanel;

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
        ESPECTÁCULOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HOSTELERÍAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ENTRADASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
