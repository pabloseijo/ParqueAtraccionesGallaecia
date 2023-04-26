package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{

    private JButton SALIRButton;
    private JLabel IconoUsuario;
    private JLabel Pulpo;
    private JLabel NombreUsuario;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton HOSTELERIAButton;
    private JButton ENTRADASButton;
    private JButton COMPRARENTRADASButton;
    private JButton VOLVERButton;
    private JPanel MainPanel;

    public UserPage(JFrame parent, FachadaBaseDatos fachadaBaseDatos) {

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
