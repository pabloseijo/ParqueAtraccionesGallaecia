package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends JFrame{

    private JButton SALIRButton;
    private JLabel IconoUsuario;
    private JLabel Pulpo;
    private JLabel NombreUsuario;
    private JLabel IconoAtracciones;
    private JButton ATRACCIONESButton;
    private JLabel IconoEspectaculos;
    private JLabel IconoHosteleria;
    private JLabel IconoEntradas;
    private JButton ESPECTÁCULOSButton;
    private JButton HOSTELERÍAButton;
    private JButton ENTRADASButton;

    public UserPage() {

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
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
