package GUI;

import baseDatos.FachadaBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage  extends JFrame {
    private JPanel Panel1;
    private JLabel JLabel1;
    private JLabel IconoAdmin;
    private JButton EMPLEADOSButton;
    private JButton ATRACCIONESButton;
    private JButton ESPECTACULOSButton;
    private JButton SALIRButton;
    private JLabel PulpoMiguel;

    public AdminPage(FachadaBaseDatos fachadaBaseDatos){
        //ponemos el titulo de la pestaña
        setTitle("Administrador");
        //Mostramos el panel del .form
        setContentPane(Panel1);
        //Ponemos el tamaño de la ventana
        setMinimumSize(new Dimension(700,500));
        //Esto hace que se cierre al darle a la X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        EMPLEADOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeePage menuUsuario = new EmployeePage(null, fachadaBaseDatos);
                dispose();
            }
        });
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

        //Boton de Cancelar
        setVisible(true);
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
